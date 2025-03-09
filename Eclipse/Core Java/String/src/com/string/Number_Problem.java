package com.string;

public class Number_Problem {
	public static void main(String[] args) {
		System.out.println(sub(-323));
	}

	private static int sub(int num) {
		if(num < 1) return 0; // for num = 0 or -ve
		int prod = 1;
		int sum = 0;
		while (num != 0) {
			int digit = num % 10;
			prod *= digit;
			sum += digit;
			num /= 10;
		}

		return prod - sum;

	}
}
