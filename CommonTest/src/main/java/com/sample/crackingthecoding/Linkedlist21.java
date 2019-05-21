package com.sample.crackingthecoding;

import java.math.BigDecimal;
import java.math.MathContext;

public class Linkedlist21 {

	public static void main(String[] args) {
		// 4 precision 
        MathContext m = new MathContext(6);
        // Assign value to BigDecimal objects 
        BigDecimal b1 = new BigDecimal("5.99"); 
        BigDecimal b2 = new BigDecimal("4.6"); 
  
        // Multiply b1 with b2 using m 
        BigDecimal b3 = b1.multiply(b2); 
  
        // Print b3 value 
        System.out.println("Multiplication is " + b3); 
	}

}
