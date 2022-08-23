package com.example.retrofittask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.MyHolder> {

    Context context;
    List<Country_Model> country_modelList = new ArrayList<>();

    public JsonAdapter(Context context, List<Country_Model> country_modelList) {
        this.context = context;
        this.country_modelList = country_modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.country,parent,false);
        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.countrynameTxt.setText(" "+country_modelList.get(position).getCountryName());
        holder.capital.setText(" "+country_modelList.get(position).getCapital());
        holder.state.setText(" "+country_modelList.get(position).getState());
        holder.company.setText(" "+country_modelList.get(position).getCompany());
        holder.pm.setText(" "+country_modelList.get(position).getDetails_model().getPm());
        holder.population.setText(" "+country_modelList.get(position).getDetails_model().getPopulation());

        Glide.with(context).load(country_modelList.get(position).getUrl())
                .centerCrop().placeholder(R.mipmap.ic_launcher).into(holder.imagedisplay);

    }

    @Override
    public int getItemCount()
    {

        return country_modelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView countrynameTxt,capital,state,company,pm,population;
        ImageView imagedisplay;
        public MyHolder(@NonNull View itemView)
        {
            super(itemView);

            countrynameTxt=itemView.findViewById(R.id.countryid);
            capital=itemView.findViewById(R.id.capitalid);
            state=itemView.findViewById(R.id.stateid);
            company=itemView.findViewById(R.id.companyid);
            pm=itemView.findViewById(R.id.pmid);
            population=itemView.findViewById(R.id.populationid);

            imagedisplay=itemView.findViewById(R.id.image);

        }
    }
}
