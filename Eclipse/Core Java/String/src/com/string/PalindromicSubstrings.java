package com.string;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println("Palindromic substrings: " + countPalindromicSubstrings(str));
        
        for (int i = 0; i < str.length()-1 ; i++) {
			for (int j = i+1; j < str.length(); j++) {
				if(Palindrome.isPalindrome(str, i, i)) {
					System.out.println(str.substring(i,j+1));
				}
			}
		}
    }

    
    
    
    
    public static int countPalindromicSubstrings(String str) {
        int count = 0;
        for (int center = 0; center < 2 * str.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
