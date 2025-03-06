package com.array;

public class Second_Min {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println(secondMinNum(a));
		
	}
	
	public static int secondMinNum(int[] a) {
		int firstMin = a[0];
		int secondMin = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if(a[i]==firstMin) continue;
			if(a[i] < firstMin) {
				secondMin = firstMin;
				firstMin = a[i];
			}
			else if (a[i] < secondMin || secondMin == firstMin ) {
				secondMin = a[i];
			}
		}
		return secondMin;
	}
}
