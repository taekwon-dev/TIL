package problem_solving.leetcode.blind_75.top_k_frequent_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ps_2025_01_13 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        for (int num : frequencyMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = heap.poll();
        }

        return answer;
    }
}
