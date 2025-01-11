package two_Dimenstional;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] a = { 9, 3, 5, 1, 7, 4, 6 };
		bubbleSort(a);

		int[] b = { 9, 3, 5, 1, 7, 4, 6 };
		bubbleSort(b, b.length);
		System.out.println(Arrays.toString(b));
		
		int[] c = { 9, 3, 5, 1, 7, 4, 6 };
		selectionSort(c);
		
	}

	//Bubble Sort by using Loop
	public static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	//Bubble Sort by using Recursion
	public static void bubbleSort(int[] a, int len) {

		if (len == 1)
			return;

		for (int i = 0; i < len - 1; i++) {
			if (a[i] > a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}

		bubbleSort(a, len - 1);

	}

	//Selection Sort by using Loop
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int minIdex = i;
			
			System.out.println(a[minIdex]);
			for (int j = 0; j < a.length; j++) {
				if(a[j] < a[minIdex]) minIdex=j;
			}
			int temp = a[minIdex];
			a[minIdex]=a[i];
			a[i]=temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
