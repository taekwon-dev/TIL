package com.til.algorithm.programmers.summer_winter_coding;

public class LV2_멀쩡한사각형 {

    public long solution(int w, int h) {
        long gcd = gcd(w, h);
        return ((long) w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
    }

    private int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}