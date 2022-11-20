package com.til.algorithm.algorithm.bitmask;

/**
 * int = 4 bytes (32 bit)
 */

public class GetBit {

    public static void main(String[] args) {
        // 1 0 0 1
        // ↑
        System.out.println(getBit(9, 3));
        // 0 1 0 1
        // ↑
        System.out.println(getBit(5, 3));
    }

    private static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
}
