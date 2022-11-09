package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class LV2_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> feeMap = new TreeMap<>();
        Map<String, String> logMap = new HashMap<>();

        for (String log : records) {
            String[] token = log.split(" ");
            String time = token[0];
            String number = token[1];
            String tag = token[2];

            if (tag.equals("IN")) {
                logMap.put(number, time);
            }

            if (tag.equals("OUT")) {
                String enterTime = logMap.remove(number);
                int usuageTime = convertToMinuteUnit(time) - convertToMinuteUnit(enterTime);
                feeMap.put(number, feeMap.getOrDefault(number, 0) + usuageTime);
            }
        }

        for (String number : logMap.keySet()) {
            int usuageTime = convertToMinuteUnit("23:59") - convertToMinuteUnit(logMap.get(number));
            feeMap.put(number, feeMap.getOrDefault(number, 0) + usuageTime);
        }

        List<String> numbers = new ArrayList<>(feeMap.keySet());
        int[] answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            if (feeMap.get(numbers.get(i)) <= fees[0]) {
                answer[i] = fees[1];
                continue;
            }
            int usuageTime = feeMap.get(numbers.get(i));
            answer[i] = fees[1] + (int) (Math.ceil((usuageTime - fees[0]) / (double) fees[2]) * fees[3]);
        }
        return answer;
    }

    private int convertToMinuteUnit(String time) {
        String[] hourAndMinute = time.split(":");
        int hour = Integer.valueOf(hourAndMinute[0]) * 60;
        int minute = Integer.valueOf(hourAndMinute[1]);
        return hour + minute;
    }
}
