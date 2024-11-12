
import java.util.Scanner;

public class N8 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number of rows : ");
        int row = scn.nextInt();
        System.out.print("Enter a number of cols : ");
        int col = scn.nextInt();

        int num = 1;
        for (int i = 1; i <= row; i++) {
            if (i % 2 == 0) {
                for (int j = col; j >= 1; j--) {
                    System.out.print(num + " ");
                    num ++;
                }
            } else {
                int temp = num + col - 1;
                for (int j = 1; j <= i; j++) {
                    System.out.print(temp - j + " ");
                }
                num += col;
            }
            System.out.println();
        }
    }
}
