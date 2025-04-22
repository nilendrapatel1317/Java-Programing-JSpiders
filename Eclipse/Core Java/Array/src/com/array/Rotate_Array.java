package com.array;

import java.util.Arrays;

public class Rotate_Array {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("Before Rotate : " + Arrays.toString(a));

		rotate(a, 3);
		System.out.println(Arrays.toString(a));
	}

	public static void rotate(int[] a, int n) {
		int len = a.length;
		for (int i = 0; i < n; i++) {
			int lastElem = a[len - 1];
			for (int j = len - 2; j >= 0; j--) {
				a[j + 1] = a[j];
			}
			a[0] = lastElem;
		}
	}
}
