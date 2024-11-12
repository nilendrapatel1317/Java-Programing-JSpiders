import java.util.Scanner;

public class PerfectNumber {
    public static int  perfect(int n, int i ){
        if(i==0) return 0;
        
        if(n%i==0) return i + perfect(n, i-1);

        return perfect(n, i-1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scn.nextInt();
        int res = perfect(num,num/2); 
        // System.out.println(res);
        if(res==num){
            System.out.println(num + " is a Perfect Number ");
        }
        else{
            System.out.println(num + " is not a Perfect Number");
        }

        main(null);
    }
}
