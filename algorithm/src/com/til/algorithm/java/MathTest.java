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
}
