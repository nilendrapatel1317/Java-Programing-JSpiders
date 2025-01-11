
package Sorting;

import java.util.Arrays;

public class Selection_Sort {

	public static void main(String[] args) {
		int[] array = { 64, 25, 12, 22, 11 };

		System.out.println("Array before sorting (Ascending):");
		System.out.println(Arrays.toString(array));

		selectionSortAscending(array);

		System.out.println("Array after sorting (Ascending):");
		System.out.println(Arrays.toString(array));
	}

	public static void selectionSortAscending(int[] array) {
		int n = array.length;


		for (int j = 0; j < array.length; j++) {
			int minIndex = j;
			for (int i = j + 1; i < n; i++) {
				if (array[i] > array[minIndex]) {
					minIndex = i;
				}
			}

			// Swap the found minimum element with the element at the starting index
			int temp = array[minIndex];
			array[minIndex] = array[j];
			array[j] = temp;
		}

	}

}
