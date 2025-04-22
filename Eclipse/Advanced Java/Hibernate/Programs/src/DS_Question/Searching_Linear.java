package DS_Question;

import java.util.Arrays;

public class Searching_Linear {
	public static void main(String[] args) {
		int[] a = { 27, 23, 1, 2, 4, 54, 32, 1, 34, 5, 55, 7, 8 };
		System.out.println(search(a, 1));

	}

	private static int search(int[] a, int i) {

		for (int j = 0; j < a.length; j++) {
			if (a[j] == i)
				return j;
		}

		return -1;
	}
}
