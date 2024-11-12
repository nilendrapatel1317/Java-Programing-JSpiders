import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();

        int res = factorial(num);
        System.out.println("res " + res);

    }

    static int factorial(int n){
        if(n==0 || n==1) return 1;
        return n * factorial(n-1);
    }
}
