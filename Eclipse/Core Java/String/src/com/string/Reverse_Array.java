package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Reverse_Array {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		ArrayList<Integer> result = reverse(arr);
		System.out.println(result); // output : [6, 5, 4, 3, 2, 1]
	}

	private static ArrayList<Integer> reverse(int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = arr.length-1; i >= 0; i--) {
			result.add(arr[i]);
		}
		
		return result;
		
	}
}
