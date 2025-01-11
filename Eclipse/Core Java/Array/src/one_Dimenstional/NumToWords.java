package one_Dimenstional;

public class NumToWords {

	private static final String[] UNITS = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };
	private static final String[] TEENS = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };
	private static final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	public static String convertToWords(int number) {
		if (number == 0) {
			return "Zero";
		}
		if (number < 0) {
            return "Minus " + convertToWords(-number);
        }

		// Divide the number into parts for Indian currency
		int crore = number / 10000000;
		number %= 10000000;

		int lakh = number / 100000;
		number %= 100000;

		int thousand = number / 1000;
		number %= 1000;

		int hundred = number / 100;
		number %= 100;

		String result = "";

		if (crore > 0) {
			result += getTwoDigitWords(crore) + " Crore ";
		}
		if (lakh > 0) {
			result += getTwoDigitWords(lakh) + " Lakh ";
		}
		if (thousand > 0) {
			result += getTwoDigitWords(thousand) + " Thousand ";
		}
		if (hundred > 0) {
			result += UNITS[hundred] + " Hundred ";
		}
		if (number > 0) {
			result += getTwoDigitWords(number);
		}

		return result.trim();
	}

	private static String getTwoDigitWords(int number) {
		if (number < 10) {
			return UNITS[number];
		} else if (number < 20 && number > 10) {
			return TEENS[number - 11];
		} else {
			return TENS[number / 10] + " " + UNITS[number % 10];
		}
	}

	public static void main(String[] args) {
		int number = -11045678;
		System.out.println("Number: " + number);
		System.out.println("In Words: " + convertToWords(number));
	}
}
