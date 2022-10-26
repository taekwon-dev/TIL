package com.til.algorithm.programmers.kakao.tech_internship_2022;

import java.util.HashMap;
import java.util.Map;

public class LV1_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        for (char[] c : types) {
            map.put(c[0], 0);
            map.put(c[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {

            String s =  survey[i];
            char D = s.charAt(0);
            char A = s.charAt(1);

            int choice = choices[i];
            switch (choice) {
                case 1:
                    map.put(D, map.get(D) + 3);
                    break;
                case 2:
                    map.put(D, map.get(D) + 2);
                    break;
                case 3:
                    map.put(D, map.get(D) + 1);
                    break;
                case 4:
                    break;
                case 5:
                    map.put(A, map.get(A) + 1);
                    break;
                case 6:
                    map.put(A, map.get(A) + 2);
                    break;
                case 7:
                    map.put(A, map.get(A) + 3);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int l = map.get(types[i][0]);
            int r = map.get(types[i][1]);

            if (l > r) {
                sb.append(types[i][0]);
            } else if (l < r) {
                sb.append(types[i][1]);
            } else {
                sb.append(types[i][0]);
            }
        }
        return sb.toString();
    }
}
