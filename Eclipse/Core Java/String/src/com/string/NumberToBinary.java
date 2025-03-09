package com.string;

import java.util.Scanner;

public class NumberToBinary {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		System.out.println(numToBin(number));

	}

	private static int numToBin(int num) {
		String binary = "";
		int count = 0;
		while (num > 0) {
			int remainder = num % 2;
			if (remainder == 1) count++;
			binary = remainder + binary;
			num = num / 2;
		}

		return count;
	}
}
