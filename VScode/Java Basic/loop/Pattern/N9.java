import java.util.Scanner;

public class N9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size , js = scn.nextInt();
        System.out.println(js);

        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i*2-1; j++) {
                if(j==size || j==1 || i==size)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }









        
        // for (int i = size-1; i >=1; i--) {
        //     for (int j = size; j >= i; j--) {
        //         System.out.print(" ");
        //     }
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     for (int j = 1; j <= i-1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();

        // }
    }
}
