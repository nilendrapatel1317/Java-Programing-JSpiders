package one_Dimenstional;

public class NumberToWord {

    // Arrays for word representation
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" , "Ten"};
    private static final String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }
        if (number < 0) {
            return "Minus " + convertToWords(-number);
        }
        
        String result = "";

        // Crore
        if (number >= 10000000) {
            result += getWords(number / 10000000) + " Crore ";
            number %= 10000000;
        }

        // Lakh
        if (number >= 100000) {
            result += getWords(number / 100000) + " Lakh ";
            number %= 100000;
        }

        // Thousand
        if (number >= 1000) {
            result += getWords(number / 1000) + " Thousand ";
            number %= 1000;
        }

        // Hundred
        if (number >= 100) {
            result += getWords(number / 100) + " Hundred ";
            number %= 100;
        }

        // Tens and units
        if (number > 0) {
        	result += getWords(number);
        }

        return result.trim();
    }

    private static String getWords(int number) {
    	if (number <= 10) {
    		return units[number];
        } else if (number < 20) {
            return teens[number - 11];
        } else {
            return tens[number / 10] + " " + units[number % 10];
        }
    }

    public static void main(String[] args) {
        int number = 3011023;
        System.out.println("Number: " + number);
        System.out.println("In Words: " + convertToWords(number));
    }
}

