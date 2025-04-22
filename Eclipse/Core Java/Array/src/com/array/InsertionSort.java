package com.array;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 3, 55, 8, 2, 5, 1, 11, 34, 16, 33, 55 };
		iSort(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void iSort(int[] arr, int i) {

		if(i>=arr.length-1) return;
		
		int key = arr[i];
		int j = i-1;
		
		while(j>=0 && arr[j]>key) {
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1] = key;
		
		iSort(arr, i+1);
	}
}
