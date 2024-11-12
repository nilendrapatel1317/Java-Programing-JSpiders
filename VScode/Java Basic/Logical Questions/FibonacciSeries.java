
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number of terms :");
        int num = scn.nextInt();

        int first = 0, second =1;
        
        // By using for loop
        // start for loop
        for (int i = 1; i <= num; i++) {
            System.out.println(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        // end for loop

        // // By using While loop 
        // // start whiile loop
        // int i =1;
        // while (i <= num) {
        //     System.out.println(first + " ");
        //     int next = first + second;
        //     first = second;
        //     second = next;
        //     i++;
        // }
        // // end while loop

        main(null);
    }
}
