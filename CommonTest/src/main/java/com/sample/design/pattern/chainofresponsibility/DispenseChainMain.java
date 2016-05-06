package com.sample.design.pattern.chainofresponsibility;

import java.util.Scanner;

public class DispenseChainMain {

	private DispenseChain c1;
	
	public DispenseChainMain() {
		// initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
 
        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		DispenseChainMain atmDispenser = new DispenseChainMain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }

	}

}
