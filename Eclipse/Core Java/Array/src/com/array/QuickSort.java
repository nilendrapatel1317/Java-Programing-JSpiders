package com.array;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 3,55,8, 2, 5, 1, 11, 34, 16, 33, 55 };
		qSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void qSort(int[] arr, int start, int end) {
		
		if(start>end) return;
		
		int pivot = arr[(start+end)/2];
		
		int i = start;
		int j = end;
		
		while(i<=j) {
			while(arr[i]<pivot) i++;
			while(arr[j]>pivot) j--;
			
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		qSort(arr, start, j);
		qSort(arr, i, end);
	}
}
