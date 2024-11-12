
import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int num = scn.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = num; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
