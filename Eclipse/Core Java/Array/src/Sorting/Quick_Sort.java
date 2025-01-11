package Sorting;

import java.util.Arrays;

public class Quick_Sort {
	public static void main(String[] args) {
		int[] a = { 2, 7, 4, 9, 3, 5, 7, 2, 8, 9 };
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void sort(int[] a, int start, int end) {
		if (start >= end)
			return;

		int pivot = a[(start + end) / 2];
		int i = start;
		int j = end;
		
		while(i<=j) {
			//for left side
			while(a[i]<pivot) i++;
			
			//for right side
			while(a[j]>pivot) j--;
			
			//for swap
			if(i<=j) {
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
		}
		sort(a, start, j);
		sort(a, i, end);
		
		
	}
}
