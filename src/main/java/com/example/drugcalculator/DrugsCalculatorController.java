package com.example.drugcalculator;

import com.example.drugcalculator.Calculable;
import com.example.drugcalculator.DrugDose;
import com.example.drugcalculator.Ibuprofen;
import com.example.drugcalculator.Paracetamol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController
public class DrugsCalculatorController {


    private Map<String, Calculable> drugNameToAmountOfSubstanceIn1ml = new HashMap<>();


    @PostConstruct
    public void initialize() {
        drugNameToAmountOfSubstanceIn1ml.put("APAP dla dzieci FORTE (200mg/5ml)", new Paracetamol(40));
        drugNameToAmountOfSubstanceIn1ml.put("Calpol (120mg/5ml)", new Paracetamol(24));
        drugNameToAmountOfSubstanceIn1ml.put("Calpol 6 Plus (250mg/5ml)", new Paracetamol(50));
        drugNameToAmountOfSubstanceIn1ml.put("Panadol dla dzieci (120mg/5ml)", new Paracetamol(24));
        drugNameToAmountOfSubstanceIn1ml.put("Paracetamol Aflofarm (120mg/5ml)", new Paracetamol(24));
        drugNameToAmountOfSubstanceIn1ml.put("Paracetamol Galena (120mg/5ml)", new Paracetamol(24));
        drugNameToAmountOfSubstanceIn1ml.put("Paracetamol Hasco (120mg/5ml)", new Paracetamol(24));
        drugNameToAmountOfSubstanceIn1ml.put("Pedicetamol (100mg/1ml)", new Paracetamol(100));
        drugNameToAmountOfSubstanceIn1ml.put("Axoprofen Forte (40mg/ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Babyfen (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Brufen Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Bufenik (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Bufenik Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Ibufen dla dzieci (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Ibufen dla dzieci Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Ibum (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Ibum Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Ibunid dla dzieci Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Ibuprom dla Dzieci (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Ibuprom dla Dzieci Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Ibutact (200mg/5ml", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Kidofen (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("MIG dla dzieci (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("MIG dla dzieci Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Milifen (100mg/5ml", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Nurofen dla dzieci (100mg/5ml)", new Ibuprofen(20));
        drugNameToAmountOfSubstanceIn1ml.put("Nurofen dla dzieci Forte (200mg/5ml)", new Ibuprofen(40));
        drugNameToAmountOfSubstanceIn1ml.put("Nurofen dla dzieci JUNIOR (200mg/5ml)", new Ibuprofen(40));
    }

    @GetMapping("/drugDose")
    public DrugDose getDoses(@RequestParam("drugId") String drugId, @RequestParam("bodyWeight") double bodyWeight) {
        Calculable drug = drugNameToAmountOfSubstanceIn1ml.get(drugId);
        return drug.calculateDoses(bodyWeight);
    }

    @GetMapping("/drugList")
    public List<String> getDrugList() {
        return new ArrayList<>(drugNameToAmountOfSubstanceIn1ml.keySet());
    }
}

