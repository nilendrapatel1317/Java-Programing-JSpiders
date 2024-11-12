public class Fact {
    public static void main(String[] args) {
        int n = 33; // number to find factorial of
        int fact = 1;
        
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        
        System.out.println("Factorial of " + n + " is: " + fact);
    }
}
