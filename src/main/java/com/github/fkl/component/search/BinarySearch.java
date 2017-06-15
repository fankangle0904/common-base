package com.github.fkl.component.search;

/**
 * Created by kanglefan on 17-6-15.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int pos = binarySearch(a, 1);
        System.out.println(pos);
    }

    private static int binarySearch(int[] a, int find) {
        int start = 0;
        int end = a.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > find) {
                end = mid - 1;
            } else if (a[mid] < find) {
                start = mid + 1;
            } else if (a[mid] == find) {
                return mid;
            }
        }
        return -1;
    }
}
