package com.sample.crackingthecoding;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 2, 30, 12, 1, 10, 21, 3};
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length-1);
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
		System.out.println("=====================================================");
		System.out.println("low:" + low + "--middle:" + middle + "--high:" + high);
		System.out.println("Before*****");
		printArray(array, low, middle, high);
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
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
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
		System.out.println("After*****");
		printArray(array, low, middle, high);
	}
	
	private static void printArray(int[] arr, int low, int middle, int high) {
		for (int i = 0; i < arr.length; i++) {
			if (i==low) {
				System.out.print("(");
			}
			System.out.print(arr[i] + " ");
			 if (i==middle) {
				System.out.print("||");
			} else if (i==high) {
				System.out.print(")");
			}
		}
		System.out.println("");
	}
}
