import java.util.Scanner;

public class Hollow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if(i==1 || i==size|| j==1 || j==size) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // // Another Approach
        // for (int i = 1; i <= size; i++) {
        //     if (i==1 || i== size) {
        //         for (int j = 1; j <= size; j++) {
        //             System.out.print("*");
        //         }
        //     }
        //     else{
        //         System.out.print("*");
        //         for (int j = 2; j <= size; j++) {
        //             System.out.print(" ");
        //         }
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    }
}
