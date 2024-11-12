package com.string;

public class Demo2 {

	public static void main(String[] args) {
        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }

        System.out.println("Reversed sentence: " + reversedSentence.toString().trim());
        
        
        String str = "A man, a plan, a canal, Panama";
        System.out.println("Is palindrome: " + isPalindrome(str));
    }
	

    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(cleanedStr);
        int left = 0, right = cleanedStr.length() - 1;
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
