
import java.util.Scanner;

public class N3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();
        int n = 5; // Number of rows

        for (int i = 0; i < n; i++) {
            // for (int j = 0; j < n - i; j++) {
            //     System.out.print(" ");
            // }
            int number = 1;
            for (int k = 0; k <= i; k++) {
                System.out.print(number + " ");
                number = number * (i - k) / (k + 1);
            }
            System.out.println();
        }
    }
}
