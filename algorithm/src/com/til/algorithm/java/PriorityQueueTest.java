package com.til.algorithm.java;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *  PriorityQueue - Min Heap(최소 힙)
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        // 최소 힙
        PriorityQueue<Integer> min_pq = new PriorityQueue<>();
        min_pq.add(1);
        min_pq.add(2);
        min_pq.add(3);

        // min_pq.poll() = 1
        System.out.println("min_pq.poll() = " + min_pq.poll());
        
        // 최대 힙 
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        max_pq.add(1);
        max_pq.add(2);
        max_pq.add(3);

        // max_pq.poll() = 3
        System.out.println("max_pq.poll() = " + max_pq.poll());
    }
}
