import java.util.Scanner;
public class HollowDiamond {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        // Code for Upper Pyramid
        for (int i = 1; i <= size; i++) {
            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                if(k==1 || k==(2*i-1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Code for Lower Pyramid (Inverted Pyramid)
        for (int i = size-1; i >=1 ; i--) {
            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i-1; k++) {
                if(k==1 || k==(2*i-1)){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
