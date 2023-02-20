package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathTest {

    @Test
    @DisplayName("거듭제곱 계산")
    void pow() {
        assertEquals(Math.pow(5, 2), 25);
    }

    @Test
    @DisplayName("올림")
    void ceil() {
        double d = 0.1;
        assertEquals(Math.ceil(d), 1.0);
    }

    @Test
    @DisplayName("반올림")
    void round() {
        double d1 = 0.5;
        double d2 = 0.4;

        assertEquals(Math.round(d1), 1.0);
        assertEquals(Math.round(d2), 0.0);
    }

    @Test
    @DisplayName("내림")
    void floor() {
        double d = 0.5;
        assertEquals(Math.floor(d), 0.0);
    }
}
