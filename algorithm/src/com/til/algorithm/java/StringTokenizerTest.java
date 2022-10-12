package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTokenizerTest {

    private static final String STR = "ABC-DEF-GHI";

    @Test
    @DisplayName("hasMoreTokens(), nextToken() 테스트")
    void iterateTokens() {
        StringTokenizer st = new StringTokenizer(STR, "-");
        /**
             ABC
             DEF
             GHI
         */
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    @DisplayName("countTokens() 테스트")
    void countTokens() {
        StringTokenizer st = new StringTokenizer(STR, "-");
        assertEquals(st.countTokens(), 3);
    }


}
