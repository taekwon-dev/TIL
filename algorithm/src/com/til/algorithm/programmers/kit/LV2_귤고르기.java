package com.til.algorithm.programmers.kit;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LV2_귤고르기 {

    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        ArrayList<Integer> sizes = new ArrayList<>(map.values());
        Collections.sort(sizes, Comparator.reverseOrder());

        int prefixSum = 0;
        int answer = 1;

        for (int size : sizes) {
            prefixSum += size;

            if (prefixSum >= k) {
                break;
            }
            answer++;
        }
        return answer;
    }
}