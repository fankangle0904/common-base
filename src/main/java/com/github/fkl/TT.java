package com.github.fkl;

import com.github.fkl.util.JsonUtil;

/**
 * Created by fyl on 2017/6/29.
 */
public class TT {

    public static void main(String[] args) {
        int[] A = {1, 3, 3};
        int[] B = {5, 1, 2, 3};
        int[] C;
        int signBit = 0;// 0表示正数，1表示负数
        if (A.length > B.length) {
            C = subtract(A, B);
        } else if (A.length == B.length) {
            boolean biggerA = true;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != B[i]) {
                    if (A[i] > B[i]) {
                        break;
                    } else {
                        biggerA = false;
                        break;
                    }
                }
            }
            System.out.println(biggerA);
            if (!biggerA) signBit = 1;
            C = biggerA ? subtract(A, B) : subtract(B, A);
        } else {
            C = subtract(B, A);
            signBit = 1;
        }
        System.out.println(signBit + " " + JsonUtil.encode(C));
    }

    private static int[] subtract(int[] longer, int[] shorter) {

        int aLow = longer.length - 1;
        int bLow = shorter.length - 1;
        int[] C = new int[longer.length];
        int cLow = aLow;
        while (bLow >= 0) {
            if (longer[aLow] >= shorter[bLow]) {
                C[cLow] = longer[aLow] - shorter[bLow];
            } else if (aLow >= 1) {
                // 可向高位取1
                int highPos = aLow - 1;
                while (highPos >= 0) {
                    if (longer[highPos] == 0) {
                        longer[highPos] = 9;
                        highPos--;
                    } else {
                        longer[highPos] = longer[highPos] - 1;
                        break;
                    }
                }
                C[cLow] = longer[aLow] + 10 - shorter[bLow];
            }
            aLow--;
            bLow--;
            cLow--;
        }
        while (aLow >= 0) C[cLow--] = longer[aLow--];
        return C;
    }
}
