package DS_Question;

import java.util.Scanner;

public class MarkTransitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string: ");
        String S = sc.nextLine();
        sc.close();

        // Get the marked transitions
        String marked = getMarkedTransitions(S);

        // Separate letters and digits
        String sortedResult = sortLettersAndDigits(marked);

        // Print the final output
        System.out.println(sortedResult);
    }

    // Method to get marked transitions
    private static String getMarkedTransitions(String S) {
        if (S.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        result.append(S.charAt(0)); // Always mark the first character

        boolean lastWasLetter = Character.isLetter(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char curr = S.charAt(i);

            // If switching from letter to digit OR digit to letter, mark the first occurrence
            if (Character.isLetter(curr) && !lastWasLetter) {
                result.append(curr);
                lastWasLetter = true;
            } else if (Character.isDigit(curr) && lastWasLetter) {
                result.append(curr);
                lastWasLetter = false;
            }
        }

        return result.toString();
    }

    // Method to separate letters and digits and return the sorted result
    private static String sortLettersAndDigits(String marked) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        for (char ch : marked.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.append(ch);
            } else {
                digits.append(ch);
            }
        }

        return letters.toString() + digits.toString(); // Concatenate letters first, then digits
    }
}
