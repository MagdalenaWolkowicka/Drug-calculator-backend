package com.example.drugcalculator;

public class Paracetamol implements Calculable {

    private static final int MAX_SINGE_DOSE_OF_PARACETAMOL_FOR_WEIGHT_EQUEL_TO_OR_GREATER_THAN_67_KG = 1000;
    private static final int MAX_DAILY_DOSE_OF_PARACETAMOL_FOR_WEIGHT_GREATER_THEN_OR_EQUEL_TO_45_KG = 4000;
    private static final int MILIGRAMS_OF_PARACETAMOL_PER_KILOGRAM_OF_BODY_WEIGHT = 15;
    private int amountOfSubstanceIn1Ml;

    public Paracetamol(int amountOfSubstanceIn1Ml) {
        this.amountOfSubstanceIn1Ml = amountOfSubstanceIn1Ml;
    }

    @Override
    public DrugDose calculateDoses(double bodyWeight) {
        double singleDose = 0;
        double maxDailyDose = 0;
        if (bodyWeight > 0) {
            double amountOfSubstance;
            if (bodyWeight < 66.67) {
                amountOfSubstance = bodyWeight * MILIGRAMS_OF_PARACETAMOL_PER_KILOGRAM_OF_BODY_WEIGHT;
            } else {
                amountOfSubstance = MAX_SINGE_DOSE_OF_PARACETAMOL_FOR_WEIGHT_EQUEL_TO_OR_GREATER_THAN_67_KG;
            }
            singleDose = amountOfSubstance / amountOfSubstanceIn1Ml;
            singleDose = Math.round(singleDose * 10);
            singleDose = singleDose / 10;
            maxDailyDose = calculateParacetamolMaxDailyDose(amountOfSubstanceIn1Ml, bodyWeight, singleDose);
        } else {
            System.out.println("Nieprawidłowa wartość masy ciała dziecka\n");
        }
        return new DrugDose(singleDose, maxDailyDose);
    }

    public double calculateParacetamolMaxDailyDose(double amountOfSubstanceIn1Ml, double bodyWeight, double singleDose) {
        double maxAmountOfSubstance = 0;
        double maxDailyDose = 0;
        if (bodyWeight > 0) {
            if (bodyWeight < 45 && bodyWeight >= 3) {
                maxDailyDose = singleDose * 6;
            } else if (bodyWeight >= 45) {
                maxAmountOfSubstance = MAX_DAILY_DOSE_OF_PARACETAMOL_FOR_WEIGHT_GREATER_THEN_OR_EQUEL_TO_45_KG;
                maxDailyDose = maxAmountOfSubstance / amountOfSubstanceIn1Ml;
            } else {
                maxDailyDose = singleDose * 5.5;
            }
            maxDailyDose = Math.round(maxDailyDose * 10);
            maxDailyDose = maxDailyDose / 10;
        }
        return maxDailyDose;
    }
}
