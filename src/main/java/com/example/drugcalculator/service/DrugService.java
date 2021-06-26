package com.example.drugcalculator.service;

import com.example.drugcalculator.model.Drug;

import java.util.List;

public interface DrugService {

    List<Drug> getAllDrugs();
    Drug addDrug(String drugName, String date);
    void delete(long id);
    Drug update(Drug drug);


}
