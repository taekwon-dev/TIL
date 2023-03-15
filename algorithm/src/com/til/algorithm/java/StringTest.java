package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("문자열 연결")
    void join() {
        List<String> members = Arrays.asList("pobi, jason");
        String result = String.join(",", members); // pobi, jason
        assertEquals(result, "pobi, jason");
    }

    @Test
    @DisplayName("문자열 비교 - compareTo() - 비교 대상에 문자열이 포함되어 있는 경우")
    void compareTo1() {
        String str = "abcd";

        // 기준 값에 비교 대상이 포함되어 있는 경우, 서로의 문자열 길이의 차이 값을 반환
        assertEquals(str.compareTo("a"), 3);
        assertEquals(str.compareTo("ab"), 2);
        assertEquals(str.compareTo("abc"), 1);

        // 동일한 문자열인 경우 0 반환
        assertEquals(str.compareTo("abcd"), 0);

        // 주의 !
        // compareTo() 는 같은 위치의 문자만 비교한다. 따라서 첫 번째 문자부터 순차적으로 비교해서 다를 경우 바로 아스키 값을 기준으로 처리한다.
        // abcd 의 a(97) vs c(99) -> -2
        assertEquals(str.compareTo("c"), -2);

        // 위와 같은 예시
        // a(97) vs h(104)
        assertEquals("abhg".compareTo("h"), -7);

        // 위와 다른 예시 (같은 원리 적용)
        // c(99) vs d (100)
        assertEquals("abcd".compareTo("abde"), -1);
    }

    @Test
    @DisplayName("문자열 비교 - compareTo() - 비교 대상과 전혀 다른 문자열의 경우")
    void compareTo2() {
        // 비교 대상과 전혀 다른 경우 -> 첫 번째 문자(= 서로 다름)의 아스키 코드 값으로 비교
        // a(97) vs e(101)
        // 사전 순 정렬에 활용 가능
        assertEquals("abcd".compareTo("efgh"), -4);
    }

    @Test
    @DisplayName("문자 배열을 new String() 인자로 활용")
    void 문자열배열_String_생성자인자() {
        char[] c = {'a', 'b', 'c'};
        String s = new String(c);
        assertEquals(s, "abc");
    }

    @Test
    @DisplayName("문자열 앞 뒤 공백 제거 - trim()")
    void 문자열_앞_뒤_공백제거() {
        String s = "  Hello   World  ";
        assertEquals(s.trim(), "Hello   World");
    }

    @Test
    @DisplayName("문자열 내 여러 개의 공백 제거 - replaceAll()")
    void 문자열_내_여러_개의_공백제거() {
        String s = "Hello   World";
        assertEquals(s.replaceAll(" +", ""), "HelloWorld");
        assertEquals(s.replaceAll(" +", " "), "Hello World");
    }

    @Test
    @DisplayName("indexOf() 활용 시 같은 문자열 비교 하면 0 반환")
    void 문자열_인덱스기반_탐색() {
        String s = "BCD";
        assertEquals(s.indexOf(s), 0);
    }

    @Test
    @DisplayName("mathces() 활용하여 정규식 패턴 일치여부 확인")
    void matches() {
        String source = "frodo";
        String target = "fr.d.";

        assertTrue(source.matches(target));
    }
}