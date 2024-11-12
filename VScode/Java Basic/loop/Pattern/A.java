public class A {
    public static void main(String[] args) {
        int num = 5;
        for (int i = 1; i <=num; i++) {
            for (int j = num; j >= i; j--) {
                // if(j==1 || i==num || j == i ){
             if(i==1 || j==num || j == i ){
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
