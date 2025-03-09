package com.string;

public class VowelsToSpaces {
	public static void main(String[] args) {
		String string = convert("Jojo is master because she very inteligent ");
		System.out.println(string);
	}

	private static String convert(String s) {
		String[] strArr = s.split(" ");

		String resultString = "";

		for (int i = 0; i < strArr.length; i++) {
			resultString += rearrangeLetters(strArr[i]);
			if (i < strArr.length - 1)
				resultString += " ";
		}
		return resultString;
	}

	private static String rearrangeLetters(String string) {
		String vowelArray = "AaEeIiOoUu";
		
		int count = 0;
	
		for (char strChar : string.toCharArray()) {
			if(vowelArray.indexOf(strChar) == -1) {
				count++;
			}
		}
		if(count > 3) {
			for (char strChar : string.toCharArray()) {
				for (char vowelChar : vowelArray.toCharArray()) {
					if(strChar == vowelChar) {
						string = string.replaceAll(vowelChar+"", "_");
					}
				}
			}
		}		
		return string;
	}
}
