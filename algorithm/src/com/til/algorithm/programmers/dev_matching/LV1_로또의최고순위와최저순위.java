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
        int lost = 0;
        int same = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                lost++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    same++;
                    continue;
                }
            }
        }
        int[] answer = {6, 6};
        if (same + lost >= 2) {
            answer[0] = rank.get(same + lost);
        }
        if (same >= 2) {
            answer[1] = rank.get(same);
        }
        return answer;
    }
}