package com.example.drugcalculator.service;


import com.example.drugcalculator.model.Drug;
import com.example.drugcalculator.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public List<Drug> getAllDrugs() {
        return (List<Drug>) drugRepository.findAll();
    }

    @Override
    public Drug addDrug(String drugName, String date) {
        Drug newDrug = new Drug();
        newDrug.setDrug(drugName);
        newDrug.setDate(date);
        drugRepository.save(newDrug);
        return newDrug;
    }

    @Override
    public void delete(long id) {
        drugRepository.deleteById(id);
    }

//    @Override
//    public Drug update(String drugName, String date)
//    {
//        Drug newDrug = new Drug();
//        newDrug.setDrug(drugName);
//        newDrug.setDate(date);
//        drugRepository.save(newDrug);
//        return newDrug;
//    }

    @Override
    public Drug update(Drug drug) {
        Optional<Drug> drugToUpdateOptional = drugRepository.findById(drug.getId());
        if (drugToUpdateOptional.isPresent()) {
            Drug drugToUpdate = drugToUpdateOptional.get();
            drugToUpdate.setDrug(drug.getDrug());
            drugToUpdate.setDate(drug.getDate());
            drugRepository.save(drugToUpdate);
            return drugToUpdate;
        }
        return drug;
    }

}


