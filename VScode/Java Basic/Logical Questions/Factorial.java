
import java.util.Scanner;

public class Factorial {

    // Method to calculate factorial using a loop
    static long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the range (up to N): ");
        int n = scanner.nextInt();

        System.out.println("Factorials up to " + n + ":");
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
        scanner.close();
    }
}
