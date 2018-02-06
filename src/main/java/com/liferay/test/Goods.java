package com.liferay.test;

/**
 * @author Jan Brychta
 */
public class Goods extends Item {

    private static final double TAX = 10d;
    private static final double IMPORT_TAX = 5d;


    Goods(String name, double prize, boolean isTaxFree, boolean isImportedDuty, int count) {
        super(name, isTaxFree ? 0 :TAX, isImportedDuty ? IMPORT_TAX : 0, prize, count);
    }

    @Override
    public String toInputPrintFormat() {
        return String.format("%d %s %s at %s", getCount(), getImportDutyTax() == 0 ? "" : "imported", getName(), formatPrize(getPrize()));
    }

    @Override
    public String toOutputPrintFormat() {
        return String.format("%d %s %s at %s", getCount(), getImportDutyTax() == 0 ? "" : "imported", getName(), formatPrize(countTaxPrize()));
    }
}
