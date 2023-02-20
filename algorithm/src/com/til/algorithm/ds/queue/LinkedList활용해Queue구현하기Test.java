package com.til.algorithm.ds.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.*;


class LinkedList활용해Queue구현하기Test {

    @Test
    @DisplayName("Queue 생성")
    void create() {
        Queue<Integer> q = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
    }

    @Test
    @DisplayName("Queue 값 추가")
    void add() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
    }

    @Test
    @DisplayName("Queue 값 삭제")
    void remove() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        q.remove();
        assertEquals(q.size(), 2);
        q.clear();
        assertEquals(q.size(), 0);

        // Empty -> poll() -> return null
        assertEquals(q.poll(), null);

        // Empty -> remove() -> throw NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> {
            q.remove();
        });
    }

    @Test
    @DisplayName("Queue 값 출력")
    void print() {
        Queue<Integer> q = new LinkedList<>();

        assertThrows(NoSuchElementException.class, () -> {
            q.element();
        });
        assertEquals(q.peek(), null);

        q.add(1);
        q.add(2);
        q.add(3);
        assertEquals(q.peek(), 1);
        assertEquals(q.size(), 3);
    }

}
