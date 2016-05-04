package com.sample.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class MaximumSum {
	static List<Integer> saved = new ArrayList<Integer>();

	public static void main(String[] args) {
		long start = System.nanoTime();
		int limit = 1000;
		List<Integer> L = new ArrayList<Integer>();
		for (int i=0 ; i<50; i++) {
			L.add((int)(Math.random() * 100));
		}
		Collections.sort(L);
		System.out.println(L);
		boolean[] used = new boolean[L.size()];
        int[] max = {0};
        rec2(L, limit, 0, used, max, 0);
        System.out.println(max[0]);
        long end = System.nanoTime();
        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
	}
	
	 public static boolean rec2(List<Integer> L, int limit, int cur, boolean[] used, int[] max, int index){
//		 System.out.println("Current: " + L.get(index));
         if(cur > limit){
             return false;
         }

         if(index == L.size()){
             return true;
         }
         if(!used[index]){
             used[index] = true;
             if(rec2(L, limit, cur+L.get(index), used, max, index)){
                 max[0] = Math.max(max[0], cur+L.get(index));
//                   return true;
             }
             used[index] = false;
         }

         return rec2(L, limit, cur, used, max, index+1);
     }

}
