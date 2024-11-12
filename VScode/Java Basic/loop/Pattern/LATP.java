
import java.util.Scanner;

public class LATP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            // For Solid Left Angle Triangle
            
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }

            // //For Hollow Left Angle Triangle
            // for (int j = 1; j <= i; j++) {
            //     if(i==size || j==i || j==1){
            //         System.out.print("*");
            //     }
            //     else{
            //         System.out.print(" ");
            //     }
            // }

            System.out.println();
        }

    }
}
