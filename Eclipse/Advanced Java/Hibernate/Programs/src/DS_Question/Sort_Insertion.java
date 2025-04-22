package DS_Question;

import java.util.Arrays;

public class Sort_Insertion {
	public static void main(String[] args) {
		int[] a = { 27, 23, 2, 4, 54, 32, 1, 34, 5, 55, 7, 8 };
		sort(a, 1);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a, int i) {
		if (i >= a.length - 1)
			return;
		int key = a[i];
		int j = i - 1;
		while (j >= 0 && a[j] > key) {
			a[j + 1] = a[j--];
		}
		a[j + 1] = key;

		sort(a, i + 1);
	}
}
