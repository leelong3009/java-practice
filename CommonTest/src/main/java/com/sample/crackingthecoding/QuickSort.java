package com.sample.crackingthecoding;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 2, 30, 12, 1, 10, 21, 3};
		quicksort(a, 0, a.length-1);
	}
	
	public static void quicksort(int[] a, int left, int right) {
		int index = partition(a, left, right);
		System.out.println("Index:"+index);
		if (left < index-1) {
			quicksort(a, left, index-1);
		}
		if (index < right) {
			quicksort(a, index, right);
		}
		
	}
	
	public static int partition(int[] a, int left, int right) {
		int pivot = a[(left + right) / 2];
		System.out.println("=====================================================");
		System.out.println("Left:"+left+"--Right:"+right+"--Pivot:"+pivot);
		System.out.println("Before");
		printArray(a);
		while (left < right) {
			while (a[left] < pivot) left++;
			while (a[right] > pivot) right--;
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		System.out.println("After");
		printArray(a);
		return left;
	}

	public static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left]=a[right];
		a[right]=temp;
	}
	
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
