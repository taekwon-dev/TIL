package com.til.algorithm.algorithm.bitmask;

/**
 *   1 0 0 1
 *
 *
 *   0 0 0 1
 *
 *
 *   1 0 0 1
 * & 0 1 1 1
 * ---------
 *   0 0 0 1
 *
 *
 *   0 1 1 1
 *
 *   1 0 0 0 ( 1 << 3 )
 *
 * ~ 1 0 0 0 -> 0 1 1 1
 */

public class ClearBit {
    public static void main(String[] args) {
        // 1 0 0 1 (9)
        // ↑

        // 0 0 0 1 (1)
        // ↑
        System.out.println(clearBit(9, 3));
    }

    private static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }
}
