package Sorting;

import java.util.Arrays;

public class Selection_Sort_Recursive {

	public static void main(String[] args) {
		int[] array = { 64, 25, 12, 22, 11 };

		System.out.println("Array before sorting (Ascending):");
		System.out.println(Arrays.toString(array));

		selectionSortAscending(array, 0);

		System.out.println("Array after sorting (Ascending):");
		System.out.println(Arrays.toString(array));
	}

	public static void selectionSortAscending(int[] array, int start) {
		int n = array.length;

		// Base case: If start reaches the end of the array, return
		if (start >= n - 1) {
			return;
		}

		// Find the minimum element in the remaining unsorted array
		int minIndex = start;
		for (int i = start + 1; i < n; i++) {
			if (array[i] > array[minIndex]) {
				minIndex = i;
			}
		}

		// Swap the found minimum element with the element at the starting index
		int temp = array[minIndex];
		array[minIndex] = array[start];
		array[start] = temp;

		// Recursively call the function to sort the rest of the array
		selectionSortAscending(array, start + 1);
	}

}
