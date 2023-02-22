package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerTest {

    @Test
    @DisplayName("compareTo() 테스트")
    void compareTo() {
        /**
         *   public static int compare(int x, int y) {
         *      return (x < y) ? -1 : ((x == y) ? 0 : 1);
         *   }
         *
         *   1. x < y  : -1
         *   2. x == y : 0
         *   3. x > y  : 1
         */
        assertEquals(Integer.valueOf(0).compareTo(Integer.valueOf(1)), -1);
        assertEquals(Integer.valueOf(0).compareTo(Integer.valueOf(0)), 0);
        assertEquals(Integer.valueOf(1).compareTo(Integer.valueOf(0)), 1);
    }
}
