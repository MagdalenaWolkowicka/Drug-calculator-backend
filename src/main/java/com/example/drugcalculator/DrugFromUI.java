package com.example.drugcalculator;

public class DrugFromUI {

    private String drug;
    private String datee;

    public DrugFromUI(String drugName, String datee) {
        this.drug = drugName;
        this.datee = datee;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }
}
