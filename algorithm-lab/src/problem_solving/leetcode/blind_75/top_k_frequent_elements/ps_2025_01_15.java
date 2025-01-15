package problem_solving.leetcode.blind_75.top_k_frequent_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ps_2025_01_15 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        for (int key : frequencyMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int size = Math.min(minHeap.size(), k);
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = minHeap.poll();
        }

        return answer;
    }
}
