package com.til.algorithm.algorithm.math;

public class GCD {

    public static void main(String[] args) {
        int result = gcd(12, 8);
        System.out.println(result);
    }

    /**
     * 유클리드 호제법
     * @param n
     * @param m
     * @return [int] 최대 공약수
     */
    private static int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
