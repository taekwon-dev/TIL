package com.til.algorithm.programmers.kakao.tech_internship_2020;

import java.util.Map;
import java.util.HashMap;

public class LV1_키패드누르기 {

    /**
     *  고정된 위치를 좌표계로 표현
     */
    private Map<Integer, int[]> map = new HashMap<>(){{
        put(1, new int[]{0, 0});
        put(2, new int[]{0, 1});
        put(3, new int[]{0, 2});
        put(4, new int[]{1, 0});
        put(5, new int[]{1, 1});
        put(6, new int[]{1, 2});
        put(7, new int[]{2, 0});
        put(8, new int[]{2, 1});
        put(9, new int[]{2, 2});
        put(0, new int[]{3, 1});
    }};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        /**
         *  현재 위치를 좌표계를 이용해 초기화
         */
        int lx = 3;
        int ly = 0;
        int rx = 3;
        int ry = 2;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append('L');
                lx = map.get(number)[0];
                ly = map.get(number)[1];
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                answer.append('R');
                rx = map.get(number)[0];
                ry = map.get(number)[1];
                continue;
            }
            int x = map.get(number)[0];
            int y = map.get(number)[1];
            int ld = Math.abs(x - lx) + Math.abs(y - ly);
            int rd = Math.abs(x - rx) + Math.abs(y - ry);
            if (ld < rd) {
                answer.append('L');
                lx = x;
                ly = y;
            } else if (ld > rd) {
                answer.append('R');
                rx = x;
                ry = y;
            } else {
                if (hand.equals("left")) {
                    answer.append('L');
                    lx = x;
                    ly = y;
                } else {
                    answer.append('R');
                    rx = x;
                    ry = y;
                }
            }
        }
        return answer.toString();
    }
}