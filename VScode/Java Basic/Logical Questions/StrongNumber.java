
import java.util.Scanner;

public class StrongNumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        int org = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }
        if (sum == org) {
            System.out.println("Strong Number");
        } else {
            System.out.println("Not a Strong Number");
        }
        main(null);
    }

    public static int factorial(int digit) {
        int prod = 1;
        for (int i = 1; i <= digit; i++) {
            prod *= i;
        }
        return prod;
    }
}
