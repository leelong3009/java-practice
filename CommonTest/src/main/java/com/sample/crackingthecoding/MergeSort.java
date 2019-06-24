package com.sample.crackingthecoding;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 2, 30, 12, 1, 10, 21, 3};
		int[] helper = new int[array.length];
		printArray(array);
		mergesort(array, helper, 0, array.length-1);
		printArray(array);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (high + low)/2;
			mergesort(array, helper, low, middle);
			mergesort(array, helper, middle + 1, high);
			merge(array, helper, low, middle, high);
		}
	}
	
	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = high;
		int current = low;
		
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current]=helper[helperLeft];
				helperLeft++;
			} else {
				array[current]=helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = middle - helperLeft;
		if (remaining > 0) {
			for (int i = 0; i < remaining; i++) {
				array[current + i] = helper[helperLeft + i];
			}
		}
	}
	
	private static void printArray(int[] arr) {
		System.out.println("-------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
