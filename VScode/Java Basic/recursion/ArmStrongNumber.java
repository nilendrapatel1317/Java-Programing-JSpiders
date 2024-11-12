import java.util.Scanner;

public class ArmStrongNumber {
    public static int armStrong(int n , int digit){
        if(n==0) return 0;
        return (int) Math.pow(n%10, digit)+armStrong(n/10, digit);
    }

    public static int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();

        int totalDigits = countDigits(num);

        int res = armStrong(num,totalDigits);
        if(res == num){
            System.out.println(num + " is a Armstrong Number");
        }
        else{
            System.out.println(num + " is not a Armstrong Number");
        }

        main(null);
    }

}
