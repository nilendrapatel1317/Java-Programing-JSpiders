
import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();

        int orgNumber = num;

        // find number of digits in num
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }

        num = orgNumber;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;

            // find power of given digit according to count times
            int prod = 1;
            for (int i = 1; i <= count; i++) {
                prod *= digit;
            }

            sum += prod;
            num /= 10;
        }

        if (sum == orgNumber) {
            System.out.println("Armstrong Number"); 
        }else {
            System.out.println("Not a Armstrong Number");
        }
    }
}
