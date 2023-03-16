package com.til.algorithm.programmers.kakao.tech_internship_2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class LV3_보석쇼핑 {

    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        Queue<String> queue = new LinkedList<>();

        int length = 100_000;
        int left = 0;
        int tempLeft = 0;

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            queue.offer(gem);

            while (true) {
                String peek = queue.peek();

                if (map.get(peek) > 1) {
                    map.put(peek, map.get(peek) - 1);
                    queue.poll();
                    tempLeft++;
                } else {
                    break;
                }
            }

            if (map.size() == set.size() && length > queue.size()) {
                length = queue.size();
                left = tempLeft;
            }
        }
        return new int[]{left + 1, left + length};
    }
}
