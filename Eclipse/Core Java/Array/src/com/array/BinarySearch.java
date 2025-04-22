package com.array;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 6, 7, 8, 9, 10 };
		int searchElem = 9;

		System.out.println(binSearch(arr, searchElem, 0, arr.length));
	}

	private static int binSearch(int[] arr, int searchElem, int start, int end) {

		if (start >= end)
			return -1;

		int mid = (start + end) / 2;

		if (searchElem == arr[mid])
			return mid;
		else if (searchElem < arr[mid])
			return binSearch(arr, searchElem, start, mid - 1);
		return binSearch(arr, searchElem, mid + 1, end);
	}
}
