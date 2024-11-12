import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        int org = num;

        while(num != 1 && num != 4){
            int sum =0;
            int temp = num;
            
            while(temp != 0){
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            num = sum;
        }

        if(num == 1) System.out.println(org + " is a Happy Number !");
        else System.out.println(org + " is a Sad Number !");

        main(null);
    }
}
