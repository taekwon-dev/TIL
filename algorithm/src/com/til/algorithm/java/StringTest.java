package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringTest {

    private static final String CONTAINS_NON_BLANK = "ABCDE";

    @Test
    @DisplayName("substring(int begin) : begin 부터 나머지 문자열 출력")
    void substringWithBeginOnly() {
        assertTrue(CONTAINS_NON_BLANK.substring(1).equals("BCDE"));
        assertTrue(CONTAINS_NON_BLANK.substring(2).equals("CDE"));
        assertTrue(CONTAINS_NON_BLANK.substring(3).equals("DE"));
        assertTrue(CONTAINS_NON_BLANK.substring(4).equals("E"));
    }

    @Test
    @DisplayName("substring(0) : 원본 문자열 그대로 반환")
    void substringWithBeginOnly0() {
        /**
         if (beginIndex == 0) {
         return this;
         }
         */
        assertTrue(CONTAINS_NON_BLANK.substring(0).equals(CONTAINS_NON_BLANK));
    }

    @Test
    @DisplayName("substring(int begin) : begin 가 문자열 길이와 같거나(공란 반환) 큰 경우(StringIndexOutOfBoundsException)")
    void substringWithBeginOnlyOverLen() {
        /**
         int subLen = length() - beginIndex;
         if (subLen < 0) {
         throw new StringIndexOutOfBoundsException(subLen);
         }
         */
        assertTrue(CONTAINS_NON_BLANK.substring(5).equals(""));     // 같은 경우
        assertThrows(StringIndexOutOfBoundsException.class, () -> { // 큰 경우
            CONTAINS_NON_BLANK.substring(CONTAINS_NON_BLANK.length() + 1);
        });
    }

    @Test
    @DisplayName("substring(-1) : 시작 인덱스가 음수인 경우 StringIndexOutOfBoundsException 발생")
    void substringWithBeginOnlyThrowsStringIndexOutOfBoundsException() {
        /**
         if (beginIndex < 0) {
         throw new StringIndexOutOfBoundsException(beginIndex);
         }
         */
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            CONTAINS_NON_BLANK.substring(-1);
        });
    }

    @Test
    @DisplayName("substring(int begin, int end) :  begin ~ end - 1")
    void substringWithBeginEnd() {
        assertTrue(CONTAINS_NON_BLANK.substring(0, 0).equals(""));
        assertTrue(CONTAINS_NON_BLANK.substring(0, 1).equals("A"));
        assertTrue(CONTAINS_NON_BLANK.substring(0, 2).equals("AB"));
        assertTrue(CONTAINS_NON_BLANK.substring(0, 3).equals("ABC"));
        assertTrue(CONTAINS_NON_BLANK.substring(0, 4).equals("ABCD"));
        assertTrue(CONTAINS_NON_BLANK.substring(0, 5).equals("ABCDE"));
    }

    @Test
    @DisplayName("substring(int begin, int end) : begin = 0, end = length return this")
    void substringWithBeginEndReturnThis() {
        /**
         if (beginIndex == 0 && endIndex == length) {
         return this;
         }
         */
        assertTrue(CONTAINS_NON_BLANK.substring(0, CONTAINS_NON_BLANK.length()).equals(CONTAINS_NON_BLANK));
    }

    @Test
    @DisplayName("substring(int begin, int end) : StringIndexOutOfBoundsException 발생")
    void substringWithBeginEndThrowsStringIndexOutOfBoundsException() {
        /**
             if (begin < 0 || begin > end || end > length) {
                throw new StringIndexOutOfBoundsException("begin " + begin + ", end " + end + ", length " + length);
             }
         */
        // begin < 0
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            CONTAINS_NON_BLANK.substring(-1, 0);
        });

        // begin > end
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            CONTAINS_NON_BLANK.substring(1, 0);
        });

        // end > length()
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
           CONTAINS_NON_BLANK.substring(0, CONTAINS_NON_BLANK.length() + 1);
        });
    }

    @Test
    @DisplayName("startsWith()")
    void startsWith() {
        assertTrue(CONTAINS_NON_BLANK.startsWith("A"));
    }

}
