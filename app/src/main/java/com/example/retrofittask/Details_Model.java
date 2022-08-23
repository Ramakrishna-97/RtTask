package com.example.retrofittask;

public class Details_Model {

    String pm,population;

    public Details_Model(String pm, String population) {
        this.pm = pm;
        this.population = population;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
