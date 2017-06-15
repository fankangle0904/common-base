package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        for (int i = 0; i < toSort.length; i++) {
            for (int j = toSort.length - 1; j > i; j--) {
                if (toSort[j] > toSort[j-1]) {
                    int temp = toSort[j - 1];
                    toSort[j-1] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }
        System.out.println(JsonUtil.encode(toSort));
    }
}
