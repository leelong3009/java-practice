package com.sample.common;

import java.util.Arrays;

public class KnapsackOnlyWeight {

	public static void main(String[] args) {
		int N = 6;
		double W = 19;
//		double[] weight = new double[N+2];
//		for (int n = 1; n <= N; n++) {
//            weight[n] = (double) (Math.random() * W);
//        }
		double[] weight = {0,1,2,3,6,7,8,W};
//		weight[N+1] = W;
		
		Arrays.sort(weight);
		
		System.out.println(getClosestK(weight, 4));
		double[][] opt = new double[N+2][N+2];
        boolean[][] sol = new boolean[N+2][N+2];
        
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= N + 1; w++) {

                // don't take item n
                double option1 = opt[n-1][w];

                // take item n
                double option2 = Integer.MIN_VALUE;
                if (weight[n] <= weight[w]) {
                	option2 = weight[n] + opt[n-1][getClosestK(weight, weight[w]-weight[n])];
                }

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        double w = W;
        for (int n = N; n > 0; n--) {
        	int i = getClosestK(weight, w);
            if (sol[n][i]) { take[n] = true;  w = w - weight[n]; }
            else           { take[n] = false;                    }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t" + weight[n] + "\t" + take[n]);
        }
	}
	
	public static int getClosestK(double[] a, double x) {

	    int low = 0;
	    int high = a.length - 1;

	    if (high < 0)
	        throw new IllegalArgumentException("The array cannot be empty");

	    while (low < high) {
	        int mid = (low + high) / 2;
	        assert(mid < high);
	        double d1 = Math.abs(a[mid  ] - x);
	        double d2 = Math.abs(a[mid+1] - x);
	        if (d2 <= d1)
	        {
	            low = mid+1;
	        }
	        else
	        {
	            high = mid;
	        }
	    }
	    return x >= a[low] ? low : low-1;
	}

}
