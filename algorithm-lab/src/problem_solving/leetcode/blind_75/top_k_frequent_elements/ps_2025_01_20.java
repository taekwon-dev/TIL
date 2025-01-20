package problem_solving.leetcode.blind_75.top_k_frequent_elements;

import java.util.*;

public class ps_2025_01_20 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        Set<Integer> keys = frequencyMap.keySet();

        for (int key : keys) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = minHeap.poll();
        }

        return answer;
    }
}
