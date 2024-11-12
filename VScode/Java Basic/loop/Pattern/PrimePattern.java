import java.util.Scanner;

public class PrimePattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int rows = scn.nextInt();
        int num = 2;
        boolean flag;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                
                while (true) { 
                    flag = true;

                    for (int k = 2; k <= num/2; k++) {
                        if(num%k == 0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.print(num + "\t");
                        num++;
                        break;
                    }
                    num++;
                }
            }
            System.out.println();
        }
    }
}
