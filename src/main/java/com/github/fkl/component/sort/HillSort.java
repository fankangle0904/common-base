package com.github.fkl.component.sort;

import com.github.fkl.util.JsonUtil;

/**
 * Created by kanglefan on 17-6-15.
 */
public class HillSort {
    public static void main(String[] args) {
        int[] toSort = {34, 54, 21, 56, 63, 44, 68, 33, 24, 19};
        int len = toSort.length;
        int inc = getOddNum(len);
        while (inc >= 1) {
            System.out.println(inc);
            int i, j;
            for (i = 0; i < len; i+= inc) {
                int min = toSort[i];
                for (j = i; j > 0 ; j -= inc) {
                    if (toSort[j - inc] > min) {
                        toSort[j] = toSort[j - inc];
                    } else {
                        break;
                    }
                }
                toSort[j] = min;
            }
            inc = getOddNum(inc);
        }
        System.out.println(JsonUtil.encode(toSort));
    }

    private static int getOddNum(int len) {
        int result = len / 2;
        return (result == 0) ? 0 : (result % 2 == 0) ? result + 1 : result;
    }
}
