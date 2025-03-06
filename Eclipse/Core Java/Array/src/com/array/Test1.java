package com.array;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
		System.out.println(Arrays.toString(intArray));
		System.out.println(intArray.length);
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("Element at index "+i+" : " + intArray[i]);
		}
	}
}
