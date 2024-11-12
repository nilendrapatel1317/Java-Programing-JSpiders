import java.util.Scanner;

public class AutomorphicNumber {
    static boolean automorphic(int n){
        int sqr = n*n;

        if(n==0) return true;

        while(n>0){
            if(n%10 != sqr%10 ) return false;
            n/=10;
            sqr/=10;
            
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");

        int num = scn.nextInt();

        if(automorphic(num)){
            System.out.println("Automorphic Number");
        }
        else{
            System.out.println("Not a Automorphic Number");
        }

        main(null);
    }
}
