package com.array;

public class Linear_Search {
	public static void main(String[] args) {
		int[] a = {3,2,4,43,5,56,1,24,65,13};
		
		System.out.println(linearSearch(a, 56));
		System.out.println(linearSearch(a, 10));
		System.out.println();
		System.out.println(linearSearch(a, 56, 0));
		System.out.println(linearSearch(a, 10, 0));
		
		
	}
	
	public static int linearSearch(int[] a,int elem) {
		
		for (int i = 0; i < a.length; i++) {
			if(elem == a[i]) return i;
		}
		
		return -1;
	}
	
	
	public static int linearSearch(int[] a , int elem , int start) {
		//base condition
		if(start > a.length-1) return -1;
		
		if(elem == a[start]) return start;
		
		return linearSearch(a, elem, start+1);
	}
}
