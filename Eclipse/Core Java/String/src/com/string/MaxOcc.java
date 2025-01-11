package com.string;

import java.util.*;

public class MaxOcc {
    public static void main(String[] args) {
        String s = "aabbcbbaaddcb";
        String s1 = ""; // To track already counted characters
        char maxChar = '\0'; // To store the character with maximum occurrence
        int maxCount = 0; // To store the maximum occurrence count

        for (char pointerChar : s.toCharArray()) {
            if (s1.indexOf(pointerChar) == -1) { // Check if the character is not already processed
                int count = 0;

                // Count occurrences of the current character
                for (char currentChar : s.toCharArray()) {
                    if (currentChar == pointerChar) {
                        count++;
                    }
                }

                // Update maxChar and maxCount if a new maximum is found
                if (count > maxCount) {
                    maxCount = count;
                    maxChar = pointerChar;
                }

                s1 += pointerChar; // Mark the character as processed
            }
        }

        // Print the character with maximum occurrence
        System.out.println("Character with maximum occurrence: " );
        System.out.println(maxChar + " = " + maxCount);
    }
}
