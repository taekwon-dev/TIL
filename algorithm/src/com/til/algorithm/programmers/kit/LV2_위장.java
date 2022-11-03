package com.til.algorithm.programmers.kit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LV2_위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        int answer = 1;
        for (int val : values) {
            answer *= (val + 1);
        }
        return answer - 1;
    }
}
