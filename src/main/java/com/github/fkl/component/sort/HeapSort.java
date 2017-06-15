package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        int totalTimes = toSort.length;
        int times = 1;
        while (times <= totalTimes) {
            sort(toSort, toSort.length - times);
            int temp = toSort[0];
            toSort[0] = toSort[toSort.length - times];
            toSort[toSort.length - times] = temp;
            times ++;
        }
    }

    private static void sort(int[] toSort, int n) {
        for (int i = n/2; i > 0; i--) {
            swap(toSort, i);
        }
        System.out.println(JsonUtil.encode(toSort));
    }

    private static void swap(int[] arr, int rootPos) {
        int leftPos = 2 * rootPos;
        int rightPos = 2 * rootPos + 1;
        int maxPos = (rightPos > arr.length) ? leftPos : (arr[leftPos - 1] > arr[rightPos - 1] ? leftPos : rightPos);
        maxPos = arr[maxPos - 1] > arr[rootPos - 1] ? maxPos : rootPos;
        if (maxPos != rootPos) {
            int temp = arr[rootPos - 1];
            arr[rootPos - 1] = arr[maxPos - 1];
            arr[maxPos - 1] = temp;
        }
    }
}
