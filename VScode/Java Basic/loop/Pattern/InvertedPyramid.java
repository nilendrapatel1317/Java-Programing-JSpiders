import java.util.Scanner;

public class InvertedPyramid {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int rows = scn.nextInt();

        int spaces = 0;
        int stars = rows;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();

            spaces++;
            stars-=2;
            // if (i <= rows) {
            // } 
        }
    }
}

