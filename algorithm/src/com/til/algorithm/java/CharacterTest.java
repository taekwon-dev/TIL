package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {

    private static final char UPPER_LETER = 'A';
    private static final char LOWER_LETER = 'a';
    char NUMBER = '1';

    @Test
    @DisplayName("Character.isDigit()")
    void isDigit() {
        assertTrue(Character.isDigit(NUMBER));
    }

    @Test
    @DisplayName("Character.isLetter()")
    void isLetter() {
        assertTrue(Character.isLetter(UPPER_LETER));
        assertTrue(Character.isLetter(LOWER_LETER));
    }

    @Test
    @DisplayName("Character.isUpperCase, isLowerCase")
    void isUpperCase() {
        assertTrue(Character.isUpperCase(UPPER_LETER));
    }

    @Test
    @DisplayName("Character.isLowerCase")
    void isLowerCase() {
        assertTrue(Character.isLowerCase(LOWER_LETER));
    }

    @Test
    @DisplayName("Charecter.toUpperCase(), toLowerCase")
    void toUpperCase_toLowerCase() {
        // 짝수 인덱스 대문자, 홀수 인덱스 소문자 (0-indexed)
        String input = "AbC";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                sb.append(Character.toUpperCase(input.charAt(i)));
                continue;
            }
            sb.append(Character.toLowerCase(input.charAt(i)));
        }

        // Java String의 경우 문자열 값이 동일하면 동등성 판단 True 반환
        assertEquals(sb.toString(), input);
    }
}