package com.til.algorithm.programmers.dev_matching;

import java.util.Map;
import java.util.HashMap;

public class LV1_로또의최고순위와최저순위 {

    private Map<Integer, Integer> rank = new HashMap<>(){{
        put(6, 1);
        put(5, 2);
        put(4, 3);
        put(3, 4);
        put(2, 5);
        put(1, 6);
        put(0, 6);
    }};

    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int zero = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    min++;
                    break;
                }
            }
        }

        int[] answer = {rank.get(min + zero), rank.get(min)};
        return answer;
    }
}