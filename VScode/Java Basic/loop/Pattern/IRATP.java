
import java.util.Scanner;

public class IRATP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int size = scn.nextInt();

        // for (int i = size; i >= 1 ; i--) {
        //     for (int j = 1 ; j <= i ; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 1; i <= size ; i++) {
            for (int j = size ; j >= i ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
