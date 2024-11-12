
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int range = scn.nextInt();

        System.out.println("Initial " + range + "Prime Number ");
        for (int i = 1; i <= range; i++) {
            boolean isPrime = true;
            if (i <= 1) {
                isPrime = false; 
            }else {
                for (int j = 2; j <= i/2; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
