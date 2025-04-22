package com.string;

import java.util.Arrays;

public class Shift_Zero_End {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 7, 0, 8, 0, 70, 0 };
//		output : [1, 3, 7, 8, 70, 0, 0, 0]  shift all zero's to end
		shift(arr);
	}

	private static void shift(int[] arr) {
		for (int i = 0,j=0; i < arr.length; i++) {
			if(arr[i] != 0) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
