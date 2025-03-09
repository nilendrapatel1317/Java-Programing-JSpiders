package com.string;

import java.util.Scanner;

public class RemoveVovel {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str = scanner.nextLine();
		removeVowel(str);
	}

	private static void removeVowel(String str) {
		String vowel = "AaEeIiOoUu";
		
		for (char strChar : str.toCharArray()) {
			for (char vowelChar : vowel.toCharArray()) {
				if(strChar == vowelChar) {
					str = str.replaceAll(vowelChar+"", "");
				}
			}
		}
		System.out.println("Output : "+str);
		
	}
}
