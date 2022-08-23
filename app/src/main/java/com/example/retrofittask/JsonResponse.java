package com.example.retrofittask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {

    @SerializedName("countries")
    @Expose
    private List<Country_Model> country_modelList;

    public List<Country_Model> getCountry_modelList()
    {
        return country_modelList;
    }

    public void setCountry_modelList(List<Country_Model> country_modelList){
        this.country_modelList=country_modelList;
    }
}
