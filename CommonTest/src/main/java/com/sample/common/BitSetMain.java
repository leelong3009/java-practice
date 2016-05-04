package com.sample.common;

import java.util.BitSet;

public class BitSetMain {

	public static void main(String[] args) {
		BitSet bits1 = new BitSet(16);
		bits1.set(0);
		bits1.set(1);
		
		System.out.println(bits1);
		
		int result = 0;
		for (int i=0 ; i<bits1.size(); i++) {
			if (bits1.get(i)) {
				result += (1 << i+1);
			}
		}

		System.out.println(result);
	}

}
