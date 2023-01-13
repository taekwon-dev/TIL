package com.til.algorithm.programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.List;

public class LV2_영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> pool = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (pool.size() == 0) {
                pool.add(words[i]);
                continue;
            }
            String lastWord = pool.get(pool.size() - 1);
            if (lastWord.charAt(lastWord.length() - 1) != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            if (pool.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            pool.add(words[i]);
        }
        return answer;
    }
}