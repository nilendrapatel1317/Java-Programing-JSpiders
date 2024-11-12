
import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
