package com.example.drugcalculator.controller;

import com.example.drugcalculator.DrugFromUI;
import com.example.drugcalculator.model.Drug;
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
    public Drug saveGivenDose(@RequestBody DrugFromUI givenDose) {
        Drug drug = drugService.addDrug(givenDose.getDrug(), givenDose.getDatee());
        return drug;
    }

    @DeleteMapping("/deleteGivenDose")
    public void deleteGivenDose(@RequestParam("id") long id) {
        drugService.delete(id);
    }

    @PutMapping("/updateGivenDose")
    public Drug updateGivenDose(@RequestBody Drug givenDose) {
        Drug drug = drugService.update(givenDose);
        return drug;
    }


//    @PutMapping("/updateGivenDose")
//    public void updateGivenDose(@RequestBody DrugFromUI givenDose) {
//
//    }
//
//    @DeleteMapping("/deleteGivenDose")
//    public void deleteGivenDose(@RequestParam("id") int id) {

//    }

    @GetMapping("/givenDoses")
    public List<Drug> getGivenDoses() {
        return drugService.getAllDrugs();
    }
}
