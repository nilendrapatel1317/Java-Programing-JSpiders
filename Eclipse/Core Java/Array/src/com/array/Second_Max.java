package com.array;

public class Second_Max {
	public static void main(String[] args) {
		int[] a = {8, 8, 3, 6, 5,7, 2};
		System.out.println(firstMaxNum(a));
	}
	
	public static int firstMaxNum(int[] a) {
		int firstMax = a[0];
		int secondMax = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > firstMax) {
				secondMax = firstMax;
				firstMax = a[i];
			}
			else if(a[i] > secondMax || secondMax == firstMax) {
				secondMax = a[i];
			}
			
		}
		
		return secondMax;
	}
}
