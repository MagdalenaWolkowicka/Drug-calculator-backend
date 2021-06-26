package com.example.drugcalculator;


public class DrugDose {

    private double singleDose;
    private double maxDose;

    public DrugDose(double singleDose, double maxDose) {
        this.singleDose = singleDose;
        this.maxDose = maxDose;
    }

    public double getSingleDose() {
        return singleDose;
    }

    public void setSingleDose(double singleDose) {
        this.singleDose = singleDose;
    }

    public double getMaxDose() {
        return maxDose;
    }

    public void setMaxDose(double maxDose) {
        this.maxDose = maxDose;
    }
}


