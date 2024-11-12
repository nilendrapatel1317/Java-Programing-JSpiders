import java.util.Scanner;

public class ButterflyPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = scn.nextInt(); // Number of rows (half of the butterfly)
        
        // Single loop to handle both upper and lower halves
        for (int i = 1; i <= 2 * n; i++) {
            int stars = i <= n ? i : 2 * n - i + 1; // Calculate number of stars
            int spaces = 2 * (n - stars);           // Calculate number of spaces

            // Print left side stars
            for (int j = 1; j <= stars; j++) {
                if (j==1 || j==stars) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            // Print spaces in the middle
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            // Print right side stars
            for (int j = 1; j <= stars; j++) {
                if (j==1 || j==stars) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
