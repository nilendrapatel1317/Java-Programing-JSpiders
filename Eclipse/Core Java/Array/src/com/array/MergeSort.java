package com.array;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 3, 55, 8, 2, 5, 1, 11, 34, 16, 33, 55 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
		if(arr.length == 1) return;
		
		int[] left = new int[arr.length/2];
		int[] right = new int[arr.length - left.length];

		int i = 0;
		while (i < left.length) {
			left[i] = arr[i++];
		}
		int j = 0;
		while (j < right.length) {
			right[j++] = arr[i++];
		}

		sort(left);
		sort(right);

		merge(left, right, arr);
	}

	private static void merge(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;
		
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) arr[k++] = left[i++];
			else arr[k++] = right[j++];
		}
		while(i<left.length) arr[k++] = left[i++];
		while(j<right.length) arr[k++] = right[j++];
	}
}
