package com.til.algorithm.programmers.kakao.tech_internship_2020;

import java.util.HashMap;

public class LV1_키패드누르기 {

    private HashMap<Integer, int[]> map = new HashMap<>(){{
        put(1, new int[]{1, 1});
        put(2, new int[]{1, 2});
        put(3, new int[]{1, 3});
        put(4, new int[]{2, 1});
        put(5, new int[]{2, 2});
        put(6, new int[]{2, 3});
        put(7, new int[]{3, 1});
        put(8, new int[]{3, 2});
        put(9, new int[]{3, 3});
        put(0, new int[]{4, 2});
    }};

    public String solution(int[] numbers, String hand) {
        int lx = 4;
        int ly = 1;
        int rx = 4;
        int ry = 3;
        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                result.append("L");
                lx = map.get(number)[0];
                ly = map.get(number)[1];
            } else if (number == 3 || number == 6 || number == 9) {
                result.append("R");
                rx = map.get(number)[0];
                ry = map.get(number)[1];
            } else {
                int x = map.get(number)[0];
                int y = map.get(number)[1];
                int ld = Math.abs(x - lx) + Math.abs(y - ly);
                int rd = Math.abs(x - rx) + Math.abs(y - ry);
                if (ld == rd) {
                    if (hand.equals("left")) {
                        result.append("L");
                        lx = x;
                        ly = y;
                    } else {
                        result.append("R");
                        rx = x;
                        ry = y;
                    }
                } else if (ld < rd) {
                    result.append("L");
                    lx = x;
                    ly = y;
                } else {
                    result.append("R");
                    rx = x;
                    ry = y;
                }
            }
        }
        return result.toString();
    }
}