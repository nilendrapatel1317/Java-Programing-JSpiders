
import java.util.Scanner;

public class N5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            for (int k = i-1; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
        for (int i = size - 1; i >= 1; i--) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            for (int k = i-1; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
