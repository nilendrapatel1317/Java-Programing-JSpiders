import java.util.Scanner;

public class N4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        
        for (int i = 1; i <= size; i++) {
            for (int j = size; j >= i; j--) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
