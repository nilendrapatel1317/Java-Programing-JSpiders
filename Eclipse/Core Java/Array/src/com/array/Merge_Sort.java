package com.array;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {

        int[] a = { 9, 3, 5, 1, 8, 4, 9, 2 };
        System.out.println("Before sort : " + Arrays.toString(a));
        sort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }

    public static void sort(int[] a) {
        if (a.length == 1)
            return;

        // Split the array into left and right array
        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - left.length];

        // Assign value to left array
        int i = 0;
        while (i < left.length) {
            left[i] = a[i++];
        }

        // Assign value to right array
        int j = 0;
        while (j < right.length) {
            right[j++] = a[i++];
        }

        // Sort left and right array
        sort(left);
        sort(right);

        // Merge Left and right array into original array
        mergeSort(left, right, a);
    }

    public static void mergeSort(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }
    }
}
