package com.array;

import java.util.Arrays;

public class SortSelection {
	public static void main(String[] args) {
		int[] arr = { 3, 55, 8, 2, 5, 1, 11, 34, 16, 33, 55 };
		sSort(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void sSort(int[] arr, int i) {
		
		if(i>=arr.length-1) return;
		
		int minIndex = i;
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[j] < arr[minIndex])
				minIndex = j;
		}
		int temp = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = temp;
		
		sSort(arr, i+1);
	}

}
