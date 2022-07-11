package com.til.algorithm.이코테.dp;

public class 피보나치_바텀업 {

    static long[] d = new long[100];
    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;

        int n = 50;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }


}
