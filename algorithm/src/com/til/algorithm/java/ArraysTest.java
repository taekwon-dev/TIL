package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArraysTest {

    @Test
    @DisplayName("Arrays.copyOfRange()")
    void copyOfRange() {
        int[] arr = {1, 2, 3, 4, 5};

        int[] temp = Arrays.copyOfRange(arr, 0, 5);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }
}