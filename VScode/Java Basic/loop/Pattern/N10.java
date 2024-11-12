import java.util.Scanner;

public class N10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            for (int j = i+1; j <= size; j++) {
                System.out.print(i+1);
            }
            System.out.println();
        }
    }
}
