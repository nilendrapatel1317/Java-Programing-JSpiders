import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int rows = scn.nextInt();
        int mid = rows / 2 + 1;

        // Code for Upper Pyramid
        for (int i = 1; i <= mid; i++) {
            for (int j = mid; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Code for Lower Pyramid (Inverted Pyramid)
        for (int i = mid-1; i >1 ; i--) {
            for (int j = mid; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    
}
