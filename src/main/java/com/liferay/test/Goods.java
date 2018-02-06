package com.liferay.test;

/**
 * @author Jan Brychta
 */
public class Goods extends Item {

    private static final double tax = 10d;
    private static final double importTax = 5d;


    Goods(String name, double prize, boolean isTaxFree, boolean isImportedDuty, int count) {
        super(name, isTaxFree ? 0 :tax, isImportedDuty ? importTax : 0, prize, count);
    }

    public String toInputPrintFormat() {
        return String.format("%d %s %s at %s", getCount(), getImportDutyTax() == 0 ? "" : "imported", getName(), formatPrize(getPrize()));
    }

    public String toOutputPrintFormat() {
        return String.format("%d %s %s at %s", getCount(), getImportDutyTax() == 0 ? "" : "imported", getName(), formatPrize(countTaxPrize()));
    }
}
