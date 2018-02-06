package com.liferay.test;

import java.text.DecimalFormat;

/**
 * @author Jan Brychta
 */
abstract class Item {

    private String name;
    private double tax;
    private double importDutyTax;
    private double prize;
    private int count;
    private double countedTaxPrize;
    private double countedTax;

    private static final DecimalFormat df2 = new DecimalFormat("#.00");

    public abstract String toInputPrintFormat();
    public abstract String toOutputPrintFormat();

    Item(String name, double tax, double importDutyTax, double prize, int count){
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name is empty");
        }
        if(tax < 0){
            throw new IllegalArgumentException("Tax can't be negative");
        }
        if(importDutyTax < 0){
            throw new IllegalArgumentException("importDutyTax can't be negative");
        }
        if(prize < 0){
            throw new IllegalArgumentException("prize can't be negative");
        }
        if(count <= 0){
            throw new IllegalArgumentException("count must be positive");
        }

        this.name = name;
        this.tax = tax;
        this.importDutyTax = importDutyTax;
        this.prize = prize;
        this.count = count;
    }

    static String formatPrize(double prize){
        return df2.format(prize);
    }

    double countTaxPrize(){
        countedTax = roundCountingResult(((importDutyTax + tax) * prize)/100);
        countedTaxPrize = countedTax + prize;

        countedTax *= count;
        countedTaxPrize *= count;

        return countedTaxPrize;
    }

    double getPrize() {
        return prize;
    }

    String getName() {
        return name;
    }

    int getCount() {
        return count;
    }

    double getImportDutyTax() {
        return importDutyTax;
    }

    double roundCountingResult(double result){
        return Math.ceil(result / 0.05d) * 0.05d;
    }

    double getCountedTaxPrize() {
        return countedTaxPrize;
    }

    double getCountedTax() {
        return countedTax;
    }

    @Override
    public String toString() {
        return String.format("Count: %d, Name: %s, Tax: %f, ImportDutyTax: %f, Prize: %f",
                this.count, this.name, this.tax, this.importDutyTax, this.prize);
    }
}
