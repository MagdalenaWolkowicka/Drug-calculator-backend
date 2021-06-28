package com.example.drugcalculator.controller;

import com.example.drugcalculator.model.GivenDose;
import com.example.drugcalculator.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class GivenDoseController {

    @Autowired
    private DrugService drugService;

    @PostMapping("/saveGivenDose")
    public GivenDose saveGivenDose(@RequestBody GivenDose givenDose) {
        GivenDose drug = drugService.addDrug(givenDose.getDrug(), givenDose.getDateOfAdministration());
        return drug;
    }

    @DeleteMapping("/deleteGivenDose")
    public void deleteGivenDose(@RequestParam("id") long id) {
        drugService.delete(id);
    }

    @PutMapping("/updateGivenDose")
    public GivenDose updateGivenDose(@RequestBody GivenDose givenDose) {
        GivenDose drug = drugService.update(givenDose);
        return drug;
    }

    @GetMapping("/givenDoses")
    public List<GivenDose> getGivenDoses() {
        return drugService.getAllDrugs();
    }
}
