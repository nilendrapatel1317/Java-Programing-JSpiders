package com.string;

public class Permutation {

    public static void main(String[] args) {
        String str = "abcd";
        findPermutations(str, "");
    }

    public static void findPermutations(String str, String prefix) {
        if (str.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                findPermutations(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }
}

