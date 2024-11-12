
import java.util.Scanner;

public class N7 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : "); // numbers of rows
        int size = scn.nextInt();
        
        System.out.print("Enter a starting number : "); // starting Number for pattern
        int num = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            if (i % 2 == 0) {
                int temp = num + i - 1;
                for (int j = 1; j <= i; j++) {
                    System.out.print(temp + " ");
                    temp--;
                }
                num += i;

            } else {
                for (int j = 1; j <= i; j++) {
                    System.out.print(num + " ");
                    num++;
                }
            }
            System.out.println();
        }
    }
}
