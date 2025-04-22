package DS_Question;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new Vector<>();

        list.add("Apple");
        list.add("Banana");
        list.add(1, "Mango"); // Index 1 pe insert hoga

        System.out.println(list); // Output: [Apple, Mango, Banana]
    }
}
