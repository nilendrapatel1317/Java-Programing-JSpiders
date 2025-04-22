package DS_Question;

import java.util.Arrays;

public class Sort_Selection {
	public static void main(String[] args) {
		int[] a = { 27, 23, 2, 4, 54, 32, 1, 34, 5, 55, 7, 8 };
		sort(a, 0);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a, int i) {
		if (i >= a.length - 1)
			return;
		int minIndex = i;
		for (int j = i + 1; j < a.length; j++) {
			if (a[j] < a[minIndex])
				minIndex = j;
		}

		int temp = a[minIndex];
		a[minIndex] = a[i];
		a[i] = temp;
		
		sort(a, i+1);
	}
}
