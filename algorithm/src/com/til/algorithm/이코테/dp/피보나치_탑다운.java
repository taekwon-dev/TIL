package com.til.algorithm.이코테.dp;

public class 피보나치_탑다운 {

    static long[] d = new long[100];
    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }

    private static long fibonacci(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibonacci(x - 1) + fibonacci(x - 2);
        return d[x];
    }


}
