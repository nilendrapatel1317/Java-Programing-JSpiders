
import java.util.Scanner;


public class RightAngleTrianglePattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Number of rows :");
        int size = scn.nextInt();
        
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }    
}
