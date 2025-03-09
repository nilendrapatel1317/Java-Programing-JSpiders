package com.string;

public class PalindromeCount {
	public static void main(String[] args) {
		int count = solution("madam is madam");
		System.out.println(count);
	}

	private static int solution(String string) {
		String[] strArr = string.split(" ");
		int count = 0;
		for (int i = 0; i < strArr.length; i++) {
			if (isPalindrom(strArr[i])) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPalindrom(String string) {
		string = string.toLowerCase();
		int i = 0;
		int j = string.length() - 1;

		while (i < j) {
			if (string.charAt(i) != string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
