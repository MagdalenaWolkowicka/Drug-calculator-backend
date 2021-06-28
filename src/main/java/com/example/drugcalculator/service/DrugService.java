package com.example.drugcalculator.service;

import com.example.drugcalculator.model.GivenDose;

import java.util.List;

public interface DrugService {

    List<GivenDose> getAllDrugs();
    GivenDose addDrug(String drugName, String dateOfAdministration);
    void delete(long id);
    GivenDose update(GivenDose givenDose);


}
