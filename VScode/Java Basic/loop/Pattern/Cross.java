import java.util.Scanner;

public class Cross {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number :");
        int size = scn.nextInt();

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if(i==j || i+j == size+1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
    }

}