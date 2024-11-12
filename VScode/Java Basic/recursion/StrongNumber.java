
import java.util.Scanner;

public class StrongNumber {

    public static int strong(int n) {
        if (n == 0) {
            return 0;
        }

        return fact(n % 10) + strong(n / 10);
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();

        int res = strong(num);

        System.out.println(num + " " + res);
        if (res == num) {
            System.out.println("Strong Number");
        } else {
            System.out.println("Not a Strong Number");
        }
    }
}
