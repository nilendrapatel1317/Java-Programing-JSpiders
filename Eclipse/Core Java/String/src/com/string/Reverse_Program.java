package com.string;

public class Reverse_Program {
	public static void main(String[] args) {
		String s="My name is Nilendra Patel"; //input
		
		
//		Case 1
//		output: "yM eman si ardneliN letaP"
		String[] strArr1 = s.split(" ");
		String str1 = "";
		for (int i = 0; i < strArr1.length; i++) {
			str1 += reverse1(strArr1[i]);
			if(i < strArr1.length-1) str1 += " ";
			
		}
		System.out.println(str1);

//		Case 2
//		output: "Patel Nilendra is name My"
		String str2 = "";
		String[] strArr2 = s.split(" ");
		for (int i = strArr2.length-1; i >= 0; i--) {
			str2 += strArr2[i];
			if(i != 0) str2 += " ";			
		}
		System.out.println(str2);
		
//		Case 3
//		output: "letaP ardneliN si eman yM"
		System.out.println(reverse1(s));
		
	}
	
	
	
	
	public static String reverse1(String s) {
		String sr = "";
		for (int i = s.length()-1; i >=0; i--) {
			sr += s.charAt(i);
		}
		return sr;
	}
	public static String reverse2(String s) {
		char[] a = s.toCharArray();
		int i=0;
		int j=a.length-1;
		while (i<j) {
			char temp = a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
			j--;
		}
		return new String(a);
	}
}
