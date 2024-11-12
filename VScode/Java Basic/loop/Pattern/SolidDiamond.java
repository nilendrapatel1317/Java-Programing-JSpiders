
import java.util.Scanner;

public class SolidDiamond {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int rows = scn.nextInt();

        int spaces = rows / 2;
        int stars = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();

            if (i <= rows / 2) {
                spaces--;
                stars+=2;
            } else {
                spaces++;
                stars-=2;
            }
        }
    }
}
