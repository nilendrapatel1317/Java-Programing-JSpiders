package com.string;

public class Permutation_Programs {
	public static void main(String[] args) {
		String s = "abc";
		permutation(s, 0, s.length());
//		permutation(s, "");
	}
	public static void permutation(String s,int start,int end) {
		if(start>=end) {
			System.out.println(s);
			return;
		}
		
		for (int i = start; i < end; i++) {
			String s1 = swap(s,start,i);
			permutation(s1, start+1, end);
		}
	}
	public static String swap(String s, int i, int j) {
		char[] a = s.toCharArray();
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return new String(a);
	}
	
	
//	Method 2 
	public static void permutation(String s , String temp) {
		//For Empty string
		if(s.isEmpty()) System.out.println(temp);
		else {
			for (int i = 0; i < s.length(); i++) {
				permutation(s.substring(0,i)+s.substring(i+1), temp + s.charAt(i));
			}
		}
	}
}







