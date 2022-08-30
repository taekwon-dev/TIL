package com.til.algorithm.algorithm.bitmask;

public class SetBit {

    public static void main(String[] args) {
        // 0 1 0 1 (5)
        // ↑

        // 1 1 0 1 (13)
        // ↑
        System.out.println(setBit(5, 3));
    }

    private static int setBit(int num, int i) {
        return num | (1 << i);
    }
}
