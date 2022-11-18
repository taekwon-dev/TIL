package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.LinkedList;
import java.util.List;

public class LV2_캐시 {

    private final int HIT = 1;
    private final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * MISS;
        }
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.remove(city)) {
                answer += HIT;
                cache.add(city);
            } else {
                answer += MISS;
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        return answer;
    }
}