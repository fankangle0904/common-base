package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        sortPart(toSort, 0, toSort.length - 1);
    }

    private static void sortPart(int[] toSort, int left, int right) {
        int basePos = left;
        int leftCursor = left;
        int rightCursor = right;
        while (leftCursor < rightCursor) {
            while (leftCursor < rightCursor) {
                if (toSort[rightCursor] < toSort[basePos]) {
                    swap(toSort, rightCursor, basePos);
                    basePos = rightCursor;
                    rightCursor--;
                    break;
                } else {
                    rightCursor--;
                }
            }
            while (leftCursor < rightCursor) {
                if (toSort[leftCursor] > toSort[basePos]) {
                    swap(toSort, leftCursor, basePos);
                    basePos = leftCursor;
                    leftCursor++;
                    break;
                } else {
                    leftCursor++;
                }
            }
        }
        System.out.println(JsonUtil.encode(toSort));
        if (left < basePos - 1) {
            sortPart(toSort, left, basePos - 1);
        }
        if (right > basePos + 1) {
            sortPart(toSort, basePos + 1, right);
        }
    }

    private static void swap(int[] toSort, int a, int b) {
        int temp = toSort[a];
        toSort[a] = toSort[b];
        toSort[b] = temp;
    }
}
