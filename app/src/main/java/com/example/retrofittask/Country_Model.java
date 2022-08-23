package com.example.retrofittask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country_Model {
    String CountryName,Capital,State,Company,url;
    @SerializedName("Details")
    @Expose
    private Details_Model details_model;

    public Country_Model(String countryName, String capital, String state, String company, String url, Details_Model details_model) {
        CountryName = countryName;
        Capital = capital;
        State = state;
        Company = company;
        this.url = url;
        this.details_model = details_model;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Details_Model getDetails_model() {
        return details_model;
    }

    public void setDetails_model(Details_Model details_model) {
        this.details_model = details_model;
    }
}
