package Java_8.Lambda_Expression;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Strong_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scn.nextInt();

        // Supplier to calculate factorial of a digit
        Function<Integer, Integer> factorial = num -> {
            int fact = 1;
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
            return fact;
        };

        // Calculate the sum of factorials of the digits
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial.apply(digit); // Get factorial of each digit
            temp /= 10;
        }

        // Function to check if the sum equals the number
        Function<Integer, Boolean> isStrong = i -> i == n;

        // Consumer to print the result
        Consumer<Integer> c = i -> System.out.println(n + (isStrong.apply(i) ? " is a Strong Number." : " is not a Strong Number."));

        // Apply the Consumer
        c.accept(sum);

        scn.close();
    }
}
