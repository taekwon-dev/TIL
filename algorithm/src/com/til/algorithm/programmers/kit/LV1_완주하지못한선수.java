package com.til.algorithm.programmers.kit;

import java.util.HashMap;
import java.util.Map;

public class LV1_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String parti : participant) {
            map.put(parti, map.getOrDefault(parti, 0) + 1);
        }

        for (String comple : completion) {
            if (map.get(comple) >= 2) {
                map.put(comple, map.get(comple) - 1);
            } else if (map.get(comple) == 1) {
                map.remove(comple);
            }
        }
        String answer = "";
        for (String key : map.keySet()) {
            answer = key;
        }
        return answer;
    }
}
