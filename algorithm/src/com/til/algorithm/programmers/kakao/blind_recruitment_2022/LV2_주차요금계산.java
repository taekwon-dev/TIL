package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashMap;
import java.util.TreeMap;

public class LV2_주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> table = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            String number = recordSplit[1];
            String status = recordSplit[2];

            if (status.equals("IN")) {
                if (!result.containsKey(number)) {
                    result.put(number, 0);
                }
                table.put(number, hashCode(time));
            } else if (status.equals("OUT")) {
                int exit = hashCode(time);
                int entrance = table.get(number);
                result.put(number, result.get(number) + (exit - entrance));
                table.remove(number);
            }
        }
        if (!table.isEmpty()) {
            table.forEach((k, v) -> {
                int exit = hashCode("23:59");
                int entrance = v;
                result.put(k, result.get(k) + (exit - entrance));
            });
        }
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int serviceTime : result.values()) {
            answer[idx] = fees[1];
            if (serviceTime > fees[0]) {
                answer[idx] += Math.ceil((serviceTime - fees[0]) / (double) fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }

    private int hashCode(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]) * 60;
        int minute = Integer.parseInt(timeSplit[1]);
        return hour + minute;
    }
}
