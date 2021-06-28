package com.example.drugcalculator.service;


import com.example.drugcalculator.model.GivenDose;
import com.example.drugcalculator.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public List<GivenDose> getAllDrugs() {
        return (List<GivenDose>) drugRepository.findAll();
    }

    @Override
    public GivenDose addDrug(String drugName, String dateOfAdministration) {
        GivenDose newGivenDose = new GivenDose();
        newGivenDose.setDrug(drugName);
        newGivenDose.setDateOfAdministration(dateOfAdministration);
        drugRepository.save(newGivenDose);
        return newGivenDose;
    }

    @Override
    public void delete(long id) {
        drugRepository.deleteById(id);
    }


    @Override
    public GivenDose update(GivenDose givenDose) {
        Optional<GivenDose> drugToUpdateOptional = drugRepository.findById(givenDose.getId());
        if (drugToUpdateOptional.isPresent()) {
            GivenDose givenDoseToUpdate = drugToUpdateOptional.get();
            givenDoseToUpdate.setDrug(givenDose.getDrug());
            givenDoseToUpdate.setDateOfAdministration(givenDose.getDateOfAdministration());
            drugRepository.save(givenDoseToUpdate);
            return givenDoseToUpdate;
        }
        return givenDose;
    }

}


