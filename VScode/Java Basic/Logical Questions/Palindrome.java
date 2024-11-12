
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a number : ");
        int num = scn.nextInt();

        int original = num;
        int reverse = 0;

        // while (num != 0) {
        //     int digit = num % 10;
        //     reverse = reverse *10 + digit;
        //     num /= 10;
        // }

        for (int i = 1; num > 0; i++) {
            int digit = num %10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        if(original == reverse) System.out.println("Palindrome Number");
        else System.out.println("Not a Palindrome Number");


        main(null);
    }
}
