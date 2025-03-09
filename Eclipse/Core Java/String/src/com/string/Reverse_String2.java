package com.string;

import java.util.Scanner;

public class Reverse_String2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String : ");
		String string = scanner.nextLine();
		reverseString(string, 20);
	}

	private static void reverseString(String string, int index) {
		try {
			char[] strArr = string.toCharArray();

			String revStr = "";

			for (int i = 0; i <= index; i++) {
				revStr += strArr[i];
			}

			for (int i = strArr.length - 1; i > index; i--) {
				revStr += strArr[i];

			}
			System.out.println("Output : " + revStr);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nIndex value is more than String Length !! Please Enter index <= string.length ");

		}
	}
}
