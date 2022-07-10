package com.til.algorithm.data_structure.priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {


        // Default, 값이 낮을 수록 우선순위가 높음
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        // 값이 높을 수록 우선순위가 높음
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        int[] nums = {1, 99, 2, 98, 3, 97};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

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
