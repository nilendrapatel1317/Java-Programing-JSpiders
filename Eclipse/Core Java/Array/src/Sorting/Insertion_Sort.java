package Sorting;

import java.util.Arrays;

public class Insertion_Sort {
	public static void main(String[] args) {
		int[] a= {5,2,6,3,1,9,4};
		System.out.println("Before sort : "+ Arrays.toString(a));
		
//		by using loop
		insertionSort1(a);
		System.out.println("After sort : "+ Arrays.toString(a));
		
//		by using recursion
		insertionSort2(a,1);
		System.out.println("After sort : "+ Arrays.toString(a));
	}
	
//		by using loop
	public static void insertionSort1(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j =i-1;
			
			while(j>=0 && a[j]>key) {
				a[j+1]=a[j--];
			}
			a[j+1]=key;
		}
	}
	
//		by using recursion
	public static void insertionSort2(int[] a, int i) {
//		base condition
		if(i >= a.length) return;
		
		int key = a[i];
		int j =i-1;
		
		while(j>=0 && a[j]>key) {
			a[j+1]=a[j--];
		}
		a[j+1]=key;
		
		insertionSort2(a, i+1);
	}
	
}
