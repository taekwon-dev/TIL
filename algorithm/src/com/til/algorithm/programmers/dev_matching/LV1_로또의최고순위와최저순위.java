package com.til.algorithm.programmers.dev_matching;

import java.util.HashMap;

public class LV1_로또의최고순위와최저순위 {

    private HashMap<Integer, Integer> rank = new HashMap<>(){{
        put(6, 1);
        put(5, 2);
        put(4, 3);
        put(3, 4);
        put(2, 5);
    }};

    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        int zero = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    match++;
                    break;
                }
            }
        }
        int high = 6;
        int low = 6;
        if (rank.containsKey(match)) {
            low = rank.get(match);
        }
        if (rank.containsKey(match + zero)) {
            high = rank.get(match + zero);
        }
        int[] answer = {high, low};
        return answer;
    }
}