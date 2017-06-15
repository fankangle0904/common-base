package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        int len = toSort.length;
        for (int i = 0; i < len - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < len; j++) {
                if (toSort[j] < toSort[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = toSort[i];
                toSort[i] = toSort[minPos];
                toSort[minPos] = temp;
            }
        }
        System.out.println(JsonUtil.encode(toSort));
    }
}
