package com.array;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = {2,5,3,10,54,23,53,11,4,24};
		int searchElem = 11;
		
		int i = linSearch(arr,searchElem);
		System.out.println(i);
	}

	private static int linSearch(int[] arr, int searchElem) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==searchElem) return i;
		}
		return -1;
	}
}
