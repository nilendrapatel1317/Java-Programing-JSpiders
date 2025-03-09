package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Shift_Zero_End {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 7, 0, 8, 0, 70, 0 };
//		output : [1, 3, 7, 8, 70, 0, 0, 0]  shift all zero's to end
		shift(arr);
	}

	private static void shift(int[] arr) {
		ArrayList<Integer> arrList = findZerosAndAssign(arr);

		int[] result = new int[arr.length];
		int pointer = 0;

		for (int i = 0; i < result.length - 1; i++) {
			if (arr[i] != 0) {
				result[pointer] = arr[i];
				pointer++;
			}
		}
		for (int i = pointer + 1; i < result.length - 1; i++) {
			if (arr[i] == 0) {
				result[i] = arrList.get(i);
			}
		}

		System.out.println(Arrays.toString(result));

	}

	private static ArrayList<Integer> findZerosAndAssign(int[] arr) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i : arr) {
			if (i == 0) {
				arrList.add(i);
			}
		}

		int[] zeroArr = new int[arrList.size()];

		for (int i = 0; i < zeroArr.length; i++) {
			zeroArr[i] = arrList.get(i);
		}
		return arrList;
	}
}
