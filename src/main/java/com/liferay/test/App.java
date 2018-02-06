package com.liferay.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan Brychta
 */
class App {

    private static final int headerPointCount = 120;

    public static void main( String[] args ) {

        if(args == null || args.length < 1){
            runAll();
        }else {
            try {
                int i = Integer.parseInt(args[0]);
                switch (i){
                    case 1:
                        runFirstExample();
                        break;
                    case 2:
                        runSecondExample();
                        break;
                    case 3:
                        runThirdExample();
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                System.out.println("Wrong argument. Possible arguments are");
                System.out.println("1  run first example");
                System.out.println("2  run second example");
                System.out.println("3  run third example");
            }

        }
    }

    private static void runAll(){
        runFirstExample();
        runSecondExample();
        runThirdExample();
    }


    private static void runFirstExample(){
        List<Item> data = new ArrayList<>();
        data.add(new Goods("book", 12.49d, true,false, 1));
        data.add(new Goods("music CD", 14.99d, false, false, 1));
        data.add(new Goods("chocolate bar", 0.85d, true, false, 1));

        runExample(data, 1);
    }

    private static void runSecondExample(){
        List<Item> data = new ArrayList<>();
        data.add(new Goods("box of chocolates", 10.00d, true,true, 1));
        data.add(new Goods("bottle of perfume", 47.50d, false, true, 1));

        runExample(data, 2);
    }

    private static void runThirdExample(){
        List<Item> data = new ArrayList<>();
        data.add(new Goods("bottle of perfume", 27.99d, false, true, 1));
        data.add(new Goods("bottle of perfume", 18.99d, false, false, 1));
        data.add(new Goods("packet of headache pills", 9.75d, true, false, 1));
        data.add(new Goods("box of imported chocolates", 11.25d, true, true, 1));

        runExample(data, 3);
    }

    private static void runExample(List<Item> items, int number){
        double salesTaxes = 0;
        double total = 0;

        System.out.println("\n");
        printHeader(number);

        for (Item item : items){
            System.out.print(item.toInputPrintFormat());
            printSecondColumn(item.toOutputPrintFormat(), true);
            salesTaxes+= item.getCountedTax();
            total += item.getCountedTaxPrize();
        }

        printSecondColumn(String.format("Sales taxes: %s", Item.formatPrize(salesTaxes)), false);
        printSecondColumn(String.format("Total: %s", Item.formatPrize(total)), false);
    }

    private static void printHeader(int number){
        String inputText = "INPUT " + number;
        printDashes(headerPointCount, true);

        System.out.print(inputText);
        printSecondColumn("OUTPUT " + number, true);

        printDashes(inputText.length(), false);
        printSecondColumn("--------", true);

    }

    private static void printSecondColumn(String value, boolean withValue){
        int max = withValue ? (headerPointCount/2) - value.length() :headerPointCount/2;
        for(int i = 0; i < max; i++ ){
            System.out.print(" ");
        }
        System.out.print(value);
        System.out.print("\n");
    }

    private static void printDashes(int count, boolean goToNewRow){
        int i = 0;
        while(i < count){
            System.out.print("-");
            i++;
        }
        if(goToNewRow)
            System.out.print("\n");
    }
}
