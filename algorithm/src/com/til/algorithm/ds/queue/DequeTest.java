package com.til.algorithm.ds.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeTest {

    @Test
    @DisplayName("Deque 생성")
    void create() {
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("Deque 값 추가")
    void add() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(3);
        dq.addFirst(1);
        dq.addLast(5);

        // dq = [1, 3, 5]
        System.out.println("dq = " + dq);
    }

    @Test
    @DisplayName("Deque 값 삭제")
    void remove() {
        Deque<Integer> dq = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));

        assertEquals(dq.remove(), 1);
        assertEquals(dq.removeFirst(), 2);
        assertEquals(dq.removeLast(), 5);

        dq.clear();
        assertEquals(dq.size(), 0);
    }

}
