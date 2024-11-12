
import java.util.Scanner;

public class ZigZagPattern {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        
        int n = scn.nextInt(); // Number of rows
        int num = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) { // For odd rows
                for (int j = 1; j <= i; j++) {
                    System.out.print(num + " ");
                    num++;
                }
            } else { // For even rows
                int temp = num + i - 1;
                for (int j = 1; j <= i; j++) {
                    System.out.print(temp + " ");
                    temp--;
                    num++;
                }
            }
            System.out.println();
        }
    }
}
