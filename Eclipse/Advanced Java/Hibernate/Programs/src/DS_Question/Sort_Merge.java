package DS_Question;

import java.util.Arrays;

public class Sort_Merge {
	public static void main(String[] args) {
		int[] a = { 27, 23, 2, 4, 54, 32, 1, 34, 5, 55, 7, 8 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		// base condition
		if (a.length == 1)
			return;

 		// split
		int[] left = new int[a.length / 2];
		int[] right = new int[a.length - left.length];

		// assign
		int i = 0;
		while (i < left.length)
			left[i] = a[i++];
		int j = 0;
		while (j < right.length)
			right[j++] = a[i++];

		// sort
		sort(left);
		sort(right);

		// merge
		merge(left, right, a);
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length)
			a[k++] = left[i] < right[j] ? left[i++] : right[j++];

		while (i < left.length)
			a[k++] = left[i++];

		while (j < right.length)
			a[k++] = right[j++];

	}
}
