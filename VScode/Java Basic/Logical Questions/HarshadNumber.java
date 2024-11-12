import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();

        int temp = num;
        int sum = 0;

        while (temp > 0){
            int digit = temp%10;
            sum+= digit;
            temp /=10;
            
        }

        if(num%sum == 0){
            System.out.println(num + " is a Harshad Number");
        }else{
            System.out.println(num + " is not a Harshad Number");
        }

        main(null);
    }
}
