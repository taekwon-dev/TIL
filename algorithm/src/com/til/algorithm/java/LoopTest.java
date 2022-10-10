package com.til.algorithm.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopTest {

    @Test
    @DisplayName("이중 Loop 내 Return")
    void loop() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println("i = " + i);
                if (i == 3) {
                    return; 
                }
            }
        }
    }
}
