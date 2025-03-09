package com.string;

public class Count_Special_Char {
	public static void main(String[] args) {
		count("R@n$n$s23_3n2#j&");
	}

	private static void count(String string) {
		int count = 0;
		for (char ch : string.toCharArray()) {
			if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z') && !(ch >= '0' && ch <= '9')) {
				count++;
			}
		}
		System.out.println(count);
	}
}
