package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashMap;
import java.util.TreeMap;

public class LV2_주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> prevTime = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            String number = recordSplit[1];
            String status = recordSplit[2];
            if (status.equals("IN")) {
                prevTime.put(number, convertToMinute(time));
                if (!result.containsKey(number)) {
                    result.put(number, 0);
                }
            } else {
                result.put(number, result.get(number) + convertToMinute(time) - prevTime.get(number));
                prevTime.remove(number);
            }
        }
        prevTime.forEach((k, v) -> {
            result.put(k, result.get(k) + 23 * 60 + 59 - v);
        });

        int[] answer = new int[result.size()];
        int idx = 0;
        for (int sum : result.values()) {
            answer[idx] = fees[1];
            if (sum > fees[0]) {
                answer[idx] += Math.ceil((sum - fees[0]) / (double) fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }

    private int convertToMinute(String time) {
        String[] timeSplit = time.split(":");
        return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
    }
}
