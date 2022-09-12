package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *  int 간 연산 결과를 실수형으로 바꾸고 싶은 경우 한 쪽에만 형 변환 적용하면 가능
 *  https://www.youtube.com/watch?v=4vzfoIKs_Dw
 */

public class LV2_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> intime = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        for (String r : records) {
            String[] str = r.split(" ");
            if (str[2].equals("IN")) {
                intime.put(str[1], convert(str[0]));
                if (!result.containsKey(str[1])) {
                    result.put(str[1], 0);
                }
            } else {
                result.put(str[1], result.get(str[1]) + convert(str[0]) - intime.get(str[1]));
                intime.remove(str[1]);
            }
        }

        intime.forEach((key, value) -> {
            result.put(key, result.get(key) + 23 * 60 + 59 - value);
        });

        int[] answer = new int[result.size()];
        int idx = 0;
        for (int val : result.values()) {
            answer[idx] = fees[1];
            if (val > fees[0]) {
                answer[idx] += Math.ceil((val - fees[0]) / (double) fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }

    private int convert(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}
