package com.til.algorithm.leetCode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LEET_1464 {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int p1 = pq.poll();
        int p2 = pq.poll();

        int maxProduct = (p1 - 1) * (p2 - 1);
        return maxProduct;
    }
}
