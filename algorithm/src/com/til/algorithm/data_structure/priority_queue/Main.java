package com.til.algorithm.data_structure.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Youn on 2022/06/02.
 * Title : 우선순위 큐
 * Hint  : 우선순위가 가장 높은 데이터를 가장 먼저 처리한다. 우선순위 (최솟값, 최댓값), 힙(완전이진트리) 자료구조 활용
 */
public class Main {
    public static void main(String[] args) {


        // Default, 값이 낮을 수록 우선순위가 높음
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        // 값이 높을 수록 우선순위가 높음
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        int[] nums = new int[]{1, 99, 2, 98, 3, 97};

        for (int num : nums) {
            minPQ.add(num);
            maxPQ.add(num);
        }

        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.poll() + " ");
        }
        System.out.println();
        while (!maxPQ.isEmpty()) {
            System.out.print(maxPQ.poll() + " ");
        }

    }
}
