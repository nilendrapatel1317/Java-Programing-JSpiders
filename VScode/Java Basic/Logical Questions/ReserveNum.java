
import java.util.Scanner;

public class ReserveNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        int reverse = 0;
        
        while(num!=0){
            int digit = num % 10;
            reverse = reverse * 10 + digit ;
            num /= 10;
        }
        
        System.out.println("Reverse of the number is : " + reverse);
        main(null);
    }
}
