package com.string;

public class Palindrome {
	public static boolean isPalindrome(String s,int startIndex , int endIndex) {
    	int i = startIndex, j = endIndex;
    	while(i < j) {
    		if(s.charAt(i) != s.charAt(j)) return false;
    		i++;
    		j--;
    	}
    	
		return true;
	}
}
