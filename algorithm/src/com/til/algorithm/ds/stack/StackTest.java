package com.til.algorithm.ds.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    @Test
    @DisplayName("Stack 생성")
    void create() {
        Stack<Integer> stack = new Stack<>();
    }

    @Test
    @DisplayName("Stack push()")
    void push() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(stack.size(), 3);
    }

    @Test
    @DisplayName("Stack peek() throw EmptyStackException")
    void peekThrowsEmptyStackException() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }

    @Test
    @DisplayName("Stack peek()")
    void peek() {
        Stack<Integer> stack = new Stack<>();

        // 3 -> curr
        // 2
        // 1
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(stack.peek(), 3);
    }
}
