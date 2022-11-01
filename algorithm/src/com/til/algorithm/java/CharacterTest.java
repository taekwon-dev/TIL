package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
