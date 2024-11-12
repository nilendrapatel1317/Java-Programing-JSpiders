
import java.util.Scanner;

public class N6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }


        // for (int i = 1; i <= size; i++) {
        //     for (int j = size; j >= size - i + 1 ; j--) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
    }
}
