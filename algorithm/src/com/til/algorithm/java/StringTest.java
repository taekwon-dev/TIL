package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("substring(int begin) : begin 이 문자열 길이와 같거나(공란 반환) 큰 경우(StringIndexOutOfBoundsException)")
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

        // A B C D E
        // 0 1 2 3 4

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
    @DisplayName("startsWith(), endsWith()")
    void startsWith() {
        assertTrue(CONTAINS_NON_BLANK.startsWith("A"));
        assertTrue(CONTAINS_NON_BLANK.endsWith("E"));
    }

    @Test
    @DisplayName("문자열 대체 - replace()")
    void replace() {
        String a = "무궁화 삼천리 화려강산 대한사람 대한으로";

        a = a.replace("대한", "민국");
        assertEquals(a, "무궁화 삼천리 화려강산 민국사람 민국으로");
    }

    @Test
    @DisplayName("문자열 대체 - replace() vs replaceAll() 차이")
    void diff_replace_replaceAll() {
        String a = "무궁화. 삼천리. 화려강산. 대한사람. 대한으로.";

        a = a.replace(".", "/");
        assertEquals(a, "무궁화/ 삼천리/ 화려강산/ 대한사람/ 대한으로/");

        // "그래서 replace() 는 특수문자로도 치환이 되는데 반하여 replaceAll() 은 특수문자로 치환이 어렵다"

        String b = "무궁화. 삼천리. 화려강산. 대한사람. 대한으로.";
        b = b.replaceAll(".", "/");
        // b = ///////////////////////////
        System.out.println("b = " + b);
    }

    @Test
    @DisplayName("문자열 대체 - replaceFirst()")
    void replaceFirst() {
        String a = "무궁화 삼천리 화려강산 대한사람 대한으로";
        a = a.replaceFirst("대한", "민국");
        assertEquals(a, "무궁화 삼천리 화려강산 민국사람 대한으로");
    }

    @Test
    @DisplayName("알파벳 문자열 - 소문자 변환")
    void toLowerCase() {
        String str = "ABCDE";
        str = str.toLowerCase();
        assertEquals(str, "abcde");
    }

    @Test
    @DisplayName("알파벳 문자열 - 대문자 변환")
    void toUpperCase() {
        String str = "abcde";
        str = str.toUpperCase();
        assertEquals(str, "ABCDE");
    }
}
