package com.array;

public class First_Max {
	public static void main(String[] args) {
		int[] a = {2,3,5,3,6,8,2,1,8};
		System.out.println(firstMaxNum(a));
	}
	
	public static int firstMaxNum(int[] a) {
		int firstMax = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > firstMax) {
				firstMax = a[i];
			}
			
		}
		
		return firstMax;
	}
}
