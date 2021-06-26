package com.example.drugcalculator;

public class Ibuprofen implements Calculable {

    private static final int MAX_SINGE_DOSE_OF_IBUPROFEN_FOR_WEIGHT_EQUEL_TO_OR_GREATER_THAN_40_KG = 400;
    private static final int MILIGRAMS_OF_IBUPROFEN_PER_KILOGRAM_OF_BODY_WEIGHT = 10;
    private int amountOfSubstanceIn1Ml;

    public Ibuprofen(int amountOfSubstanceIn1Ml) {
        this.amountOfSubstanceIn1Ml = amountOfSubstanceIn1Ml;
    }

    @Override
    public DrugDose calculateDoses(double bodyWeight) {
        double singleDose = 0;
        double maxDailyDose = 0;
        if (bodyWeight > 0) {
            double amountOfSubstance;
            if (bodyWeight < 40) {
                amountOfSubstance = bodyWeight * MILIGRAMS_OF_IBUPROFEN_PER_KILOGRAM_OF_BODY_WEIGHT;
            } else {
                amountOfSubstance = MAX_SINGE_DOSE_OF_IBUPROFEN_FOR_WEIGHT_EQUEL_TO_OR_GREATER_THAN_40_KG;
            }
            singleDose = amountOfSubstance / amountOfSubstanceIn1Ml;
            singleDose = Math.round(singleDose * 10);
            singleDose = singleDose / 10;
            maxDailyDose = calculateIbuprofenMaxDailyDose(bodyWeight, singleDose);
        } else {
            System.out.println("Nieprawidłowa wartość masy ciała dziecka\n");
        }
        return new DrugDose(singleDose, maxDailyDose);
    }

    public double calculateIbuprofenMaxDailyDose(double bodyWeight, double singleDose) {
        double maxDailyDose = 0;
        if (bodyWeight > 0) {
            if (bodyWeight > 1) {
                maxDailyDose = singleDose * 4;
            } else {
                maxDailyDose = singleDose * 3.3;
            }
            maxDailyDose = Math.round(maxDailyDose * 10);
            maxDailyDose = maxDailyDose / 10;
        }
        return maxDailyDose;
    }

}
