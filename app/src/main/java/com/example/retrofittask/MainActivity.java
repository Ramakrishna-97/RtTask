package com.example.retrofittask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Country_Model country_model;
    JsonAdapter jsonAdapter;
    List<Country_Model> country_modelList = new ArrayList<>();
    Retrofit retrofit;
    MyApi myApi;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        retrofit= new Retrofit.Builder().baseUrl("https://run.mocky.io/v3/").addConverterFactory(GsonConverterFactory.create()).build();

        myApi=retrofit.create(MyApi.class);

        jsonAdapter = new JsonAdapter(this,country_modelList);
        recyclerView.setAdapter(jsonAdapter);

        loadData();
    }

    private void loadData() {

        Call<JsonResponse> call = myApi.getResponselist();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                progressDialog.dismiss();

                if (response.code()!=200)
                {
                    Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<Country_Model> country_modelList1=response.body().getCountry_modelList();

                    for(Country_Model country_model1:country_modelList1)
                    {
                        String countryName1=country_model1.getCountryName();
                        String capital1=country_model1.getCapital();
                        String state1=country_model1.getState();
                        String company1=country_model1.getCompany();
                        String url1=country_model1.getUrl();


                        Details_Model details_model1 = new Details_Model(country_model1.getDetails_model().getPm()
                        ,country_model1.getDetails_model().getPopulation());

                        country_model = new Country_Model(countryName1,capital1,state1,company1,url1,details_model1);
                        country_modelList.add(country_model);
                        jsonAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}