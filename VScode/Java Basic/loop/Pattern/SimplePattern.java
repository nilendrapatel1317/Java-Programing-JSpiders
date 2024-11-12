public class SimplePattern {
    public static void main(String[] args) {
        int n = 4; // Number of rows and columns

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    System.out.print(i);
                } else {
                    System.out.print(i + 1);
                }
            }
            System.out.println();
        }
    }
}
