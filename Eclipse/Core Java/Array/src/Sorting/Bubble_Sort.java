package Sorting;

import java.util.Arrays;

public class Bubble_Sort {

	public static void main(String[] args) {
		int[] array = { 5, 3, 8, 4, 2 };

		System.out.println("Array before sorting:");
		System.out.println(Arrays.toString(array));

		bubbleSort(array);

		System.out.println("Array after sorting:");
		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					//swaping
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
			}
		}
	}

}
