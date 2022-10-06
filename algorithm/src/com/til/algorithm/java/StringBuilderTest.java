package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://coding-factory.tistory.com/546
 */
public class StringBuilderTest {

    private static final String S = "ABCDEFG";

    @Test
    @DisplayName("StringBuilder 생성")
    void create() {

        /**
            public StringBuilder() {
                super(16);
            }
            생성자 인자 없는 경우, Capacity 16 으로 지정 (디폴트)
         */
        StringBuilder sb = new StringBuilder();
        assertTrue(sb.capacity() == 16);

        StringBuilder sb2 = new StringBuilder(5);
        assertTrue(sb2.capacity() == 5);
    }

    @Test
    @DisplayName("StringBuilder with a given string")
    void createWithGivenString() {
        StringBuilder sb = new StringBuilder(S);

        /**
             public StringBuilder(String str) {
                super(str.length() + 16);
                append(str);
             }
             주어진 문자열을 기반으로 StringBuilder 생성 시, Capacity 를 해당 문자열 길이 + 16으로 설정
         */
        assertTrue(sb.capacity() != sb.toString().length());
    }
    
}
