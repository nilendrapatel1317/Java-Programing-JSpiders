
public class N {
    public static void main(String[] args) {
        printConsecutiveLetters("SUCCESS");
    }

    public static void printConsecutiveLetters(String str) {
        str = str.toUpperCase(); // Convert to uppercase
        int len = str.length();

        for (int i = 0; i < len - 1; i++) {
            int count = 1;
            while (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                count++;
            }
            if (count > 1) {
                System.out.print(str.charAt(i) + "" + count + " ");
            }
        }
        System.out.println();
    }
}
