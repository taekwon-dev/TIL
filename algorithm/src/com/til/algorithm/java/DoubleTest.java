package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleTest {

    @Test
    @DisplayName("compareTo() 테스트")
    void compareTo() {
        /**
         *      public static int compare(double d1, double d2) {
         *         if (d1 < d2)
         *             return -1;           // Neither val is NaN, thisVal is smaller
         *         if (d1 > d2)
         *             return 1;            // Neither val is NaN, thisVal is larger
         *
         *         // Cannot use doubleToRawLongBits because of possibility of NaNs.
         *         long thisBits    = Double.doubleToLongBits(d1);
         *         long anotherBits = Double.doubleToLongBits(d2);
         *
         *         return (thisBits == anotherBits ?  0 : // Values are equal
         *                 (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
         *                  1));                          // (0.0, -0.0) or (NaN, !NaN)
         *     }
         */
        assertEquals(Double.valueOf(0).compareTo(Double.valueOf(1)), -1);
        assertEquals(Double.valueOf(0).compareTo(Double.valueOf(0)), 0);
        assertEquals(Double.valueOf(1).compareTo(Double.valueOf(0)), 1);
    }
}