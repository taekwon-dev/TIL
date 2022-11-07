package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.LinkedList;
import java.util.List;

public class LV2_캐시 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        List<String> cache = new LinkedList<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.remove(city)) {
                answer += 1;
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        return answer;
    }
}