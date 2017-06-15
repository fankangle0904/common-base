package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * http://www.cnblogs.com/jingmoxukong/p/4308823.html
 *
 * Created by kanglefan on 17-6-15.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        sort(toSort);
        System.out.println(JsonUtil.encode(toSort));
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low; // 第一段序列起始下标
        int j = mid + 1; // 第二段序列起始下标
        int k = 0; // 临时存放合并序列的起始下标
        int[] arrTemp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                arrTemp[k++] = arr[i];
                i++;
            } else {
                arrTemp[k++] = arr[j];
                j++;
            }
        }

        while (i <= mid) arrTemp[k++] = arr[i++];
        while (j <= high) arrTemp[k++] = arr[j++];

        for (k = 0, i = low; i <= high; i++, k++) {
            arr[i] = arrTemp[k];
        }
    }

    private static void mergeByGap(int[] arr, int gap, int len) {
        int i = 0;
        for (i = 0; i < len - 2 * gap + 1; i += 2 * gap) {
            merge(arr, i, i + gap - 1, i + 2 * gap - 1);
        }
        if (i + gap - 1 < len) {
            merge(arr, i, i + gap -1, len - 1);
        }
    }

    private static void sort(int[] arr) {
        for (int gap = 1; gap < arr.length; gap *= 2) {
            mergeByGap(arr, gap, arr.length);
        }
    }
}
