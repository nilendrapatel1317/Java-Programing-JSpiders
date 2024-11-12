import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        boolean isPrime = true;
        
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        if(isPrime) System.out.println("Prime Number");
        else System.out.println("Not Prime Number");
        main(null);
        
    }
}