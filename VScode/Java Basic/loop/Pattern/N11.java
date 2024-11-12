import java.util.Scanner;

public class N11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int rows = scn.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i ; j++) {
                
                boolean isPrime = true;
                if(j <= 1) isPrime = false;
                else{
                    for(int k = 2; k <= j/2; k++) {
                        if(j%k== 0){
                            isPrime = false ;
                            break;
                        }
                    }
                }
                if(isPrime) System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
