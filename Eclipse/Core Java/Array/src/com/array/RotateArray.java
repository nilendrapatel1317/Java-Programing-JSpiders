package com.array;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Before Rotate : " + Arrays.toString(arr));

		rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] arr, int rotate) {
		int len = arr.length;
		for (int i = 0; i < rotate; i++) {
			int lastElem = arr[len - 1];
			for (int j = len - 2; j >= 0; j--) {
				arr[j + 1] = arr[j];
			}
			arr[0] = lastElem;
		}
	}
}
