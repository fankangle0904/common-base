package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44};
        int i, j;
        for (i = 0; i < toSort.length; i++) {
            int min = toSort[i];
            for (j = i; j > 0; j--) {
                if (toSort[j - 1] > min) {
                    toSort[j] = toSort[j - 1];
                } else {
                    break;
                }
            }
            toSort[j] = min;
        }
        System.out.println(JsonUtil.encode(toSort));
    }
}
