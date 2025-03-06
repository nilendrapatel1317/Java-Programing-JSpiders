package com.array;

public class Bubble_Sort_Recursive {

	public static void main(String[] args) {
		int[] array = { 5, 3, 8, 4, 2 };

		System.out.println("Array before sorting:");
		printArray(array);

		recursiveBubbleSort(array, array.length);

		System.out.println("Array after sorting:");
		printArray(array);
	}

	// Recursive Bubble Sort function
	public static void recursiveBubbleSort(int[] array, int n) {
		// Base case: If array size is 1, return
		if (n == 1) {
			return;
		}

		// Perform one pass of Bubble Sort for the first n elements
		for (int i = 0; i < n - 1; i++) {
			if (array[i] > array[i + 1]) {
				// Swap if elements are out of order
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}

		// Largest element is now at the end, so recursively call for remaining array
		recursiveBubbleSort(array, n - 1);
	}

	// Method to print the array
	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
