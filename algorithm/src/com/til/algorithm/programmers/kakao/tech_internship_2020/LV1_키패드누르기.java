package com.til.algorithm.programmers.kakao.tech_internship_2020;

import java.util.HashMap;

public class LV1_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        HashMap<Integer, int[]> map = new HashMap<>(){{
            put(1, new int[]{1,1});
            put(2, new int[]{1,2});
            put(3, new int[]{1,3});

            put(4, new int[]{2,1});
            put(5, new int[]{2,2});
            put(6, new int[]{2,3});

            put(7, new int[]{3,1});
            put(8, new int[]{3,2});
            put(9, new int[]{3,3});

            put(0, new int[]{4,2});
        }};

        int lx = 4;
        int ly = 1;
        int rx = 4;
        int ry = 3;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                lx = map.get(numbers[i])[0];
                ly = map.get(numbers[i])[1];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rx = map.get(numbers[i])[0];
                ry = map.get(numbers[i])[1];
            } else {
                int x = map.get(numbers[i])[0];
                int y = map.get(numbers[i])[1];

                int ld = Math.abs(x - lx) + Math.abs(y - ly);
                int rd = Math.abs(x - rx) + Math.abs(y - ry);

                if (ld == rd) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        lx = x;
                        ly = y;
                    } else if (hand.equals("right")) {
                        sb.append("R");
                        rx = x;
                        ry = y;
                    }
                } else if (ld < rd) {
                    sb.append("L");
                    lx = x;
                    ly = y;
                } else if (ld > rd) {
                    sb.append("R");
                    rx = x;
                    ry = y;
                }
            }
        }
        return sb.toString();
    }
}
