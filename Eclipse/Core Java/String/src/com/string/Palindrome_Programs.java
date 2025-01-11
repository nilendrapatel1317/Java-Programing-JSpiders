package com.string;

public class Palindrome_Programs {
	public static void main(String[] args) {
		
//		Check is given string is Palindrome or not
		String s1 = "madam";
		if(isPalindrome1(s1)) {
			System.out.println(s1+" is a Palindrome String");
		}
		else {
			System.out.println(s1+" is not a Palindrome String");			
		}
		
//		Print all possible palindrome string
		String s2 = "madam is madadm";
		for (int i = 0; i < s2.length()-1; i++) {
			for (int j = i+1; j < s2.length(); j++) {
				if(isPalindrome2(s2,i,j)) {
					System.out.println(s2.substring(i,j+1));
				}
			}
		}
		
//		Print all possible palindrome word in given String
		String s3 = "madam is always madam ";
		String[] strArr = s3.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			if(isPalindrome1(strArr[i])) {
				System.out.println(strArr[i]);
			}
		}
		
	}
	
	public static boolean isPalindrome1(String s) {
		String str = "";
		for (int i = s.length()-1; i>=0; i--) {
			str+=s.charAt(i);
		}
		return s.equals(str);
	}
	public static boolean isPalindrome2(String s,int start , int end) {
		int i = start;
		int j = end;
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}
