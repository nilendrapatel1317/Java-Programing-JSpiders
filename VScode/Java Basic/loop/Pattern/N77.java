import java.util.Scanner;

public class N77 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int size = scn.nextInt();

        int sum = 0;
        for (int i = 1; i <= size; i++) {
            sum += i ;
            if(i%2 != 0){
                int num = sum - i;
                for (int j = 1; j <=i; j++) {
                    num++;
                    System.out.print(num + "\t");
                }
            }else{
                int num = sum;
                for (int j = 1; j <=i; j++) {
                    System.out.print(num + "\t");
                    num--;
                }
            }
            System.out.println();
        }
    }
}
