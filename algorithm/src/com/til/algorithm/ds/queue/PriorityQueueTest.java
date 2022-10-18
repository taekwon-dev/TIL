package com.til.algorithm.ds.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriorityQueueTest {

    @Test
    @DisplayName("우선순위 큐 생성")
    void create() {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    }

    @Test
    @DisplayName("우선순위 큐 값 추가")
    void add() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertEquals(pq.peek(), 1);
    }

    @Test
    @DisplayName("우선순위 큐 값 삭제")
    void remove() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);

        assertEquals(pq.poll(), 1);
        assertEquals(pq.poll(), 2);
        pq.clear();
        assertEquals(pq.size(), 0);
        assertEquals(pq.poll(), null); // 비어 있는 경우 null 반환

        assertThrows(NoSuchElementException.class, () -> {
            // 우선순위 큐가 비어 있는 상태에서
            // poll() -> null 반환
            // remove() -> NoSuchElementException 예외
            pq.remove();
        });
    }

}
