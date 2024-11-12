
import java.util.Scanner;

public class Binarytriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            int num = i%2;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num =1 - num;
            }
            System.out.println();
        }
    }
}
