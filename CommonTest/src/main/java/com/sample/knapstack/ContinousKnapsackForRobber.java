package com.sample.knapstack;

import java.text.NumberFormat;
import java.util.List;

public class ContinousKnapsackForRobber {
	final private double tolerance = 0.0005;
	 
    public ContinousKnapsackForRobber() {
        ContinuousKnapsack cok = new ContinuousKnapsack(1005000); // 15 kg
 
        // making the list of items that you want to bring
//        cok.add("beef",     3.8, 3.8); // marhahús
//        cok.add("pork",     5.4, 5.4); // disznóhús
//        cok.add("ham",      3.6, 3.6); // sonka
//        cok.add("greaves",  2.4, 2.4); // tepertő
//        cok.add("flitch",   4.0, 4.0); // oldalas
//        cok.add("brawn",    2.5, 2.5); // disznósajt
//        cok.add("welt",     3.7, 3.7); // hurka
//        cok.add("salami",   3.0, 3.0); // szalámi
//        cok.add("sausage",  5.9, 5.9); // kolbász
        
        cok.add("beef",     100000, 100000); // marhahús
        cok.add("pork",     200000, 200000); // disznóhús
        cok.add("ham",      1000000, 1000000); // sonka
        cok.add("greaves",  550000, 550000); // tepertő
        cok.add("flitch",   100000, 100000); // oldalas
        cok.add("brawn",    60000, 60000); // disznósajt
        cok.add("welt",     99000, 99000); // hurka
        cok.add("salami",   200000, 200000); // szalámi
        cok.add("sausage",  220000, 220000); // kolbász
 
        // calculate the solution:
        List<Item> itemList = cok.calcSolution();
 
        // write out the solution in the standard output
        if (cok.isCalculated()) {
            NumberFormat nf  = NumberFormat.getInstance();
 
            System.out.println(
                "Maximal weight           = " +
                nf.format(cok.getMaxWeight()) + " kg"
            );
            System.out.println(
                "Total weight of solution = " +
                nf.format(cok.getSolutionWeight()) + " kg"
            );
            System.out.println(
                "Total value (profit)     = " +
                nf.format(cok.getProfit())
            );
            System.out.println();
            System.out.println(
                "You can carry the following materials " +
                "in the knapsack:"
            );
            for (Item item : itemList) {
                if (item.getInKnapsack() > tolerance) {
                    System.out.format(
                        "%1$-10s %2$-15s %3$-15s \n",
                        nf.format(item.getInKnapsack()) + " kg ",
                        item.getName(),
                        "(value = " + nf.format(item.getInKnapsack() *
                                                (item.getValue() / item.getWeight())) + ")"
                    );
                }
            }
        } else {
            System.out.println(
                "The problem is not solved. " +
                "Maybe you gave wrong data."
            );
        }
 
    }
 
    public static void main(String[] args) {
        new ContinousKnapsackForRobber();
    }
}
