package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class LV2_주차요금계산 {

    /**
     *  주차된 차 별로 주차 요금을 반환할 때, 차 번호 기준으로 정렬을 해야하므로
     *  차 번호(Key)를 기준으로 오름차순으로 정렬된 상태로 관리할 수 있도록 TreeMap 활용
     */
    private Map<String, Integer> totalTime = new TreeMap<>();
    private Map<String, Integer> currentStatus = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            String number = recordSplit[1];
            String flag = recordSplit[2];

            if (flag.equals("IN")) {
                currentStatus.put(number, convertToMinute(time));
                continue;
            }
            int lastInTime = currentStatus.get(number);
            currentStatus.remove(number);
            totalTime.put(number, totalTime.getOrDefault(number, 0) + convertToMinute(time) - lastInTime);
        }
        /**
         *  현재 주차된 상태를 기준으로 요금을 계산할 때 출차되지 않은 차는 23:59에 출차된 것으로 계산
         */
        currentStatus.forEach((k, v) -> {
            totalTime.put(k, totalTime.getOrDefault(k, 0) + convertToMinute("23:59") - v);
        });

        int[] answer = new int[totalTime.size()];
        int index = 0;
        for (int parkingTime : totalTime.values()) {
            answer[index] = fees[1];
            if (parkingTime > fees[0]) {
                answer[index] += Math.ceil((parkingTime - fees[0]) / (double) fees[2]) * fees[3];
            }
            index++;
        }
        return answer;
    }

    /**
     *  시간 계산할 때 '분'으로 통일해서 계산하면 편하므로, 아래와 같이 단위를 통일
     */
    private int convertToMinute(String time) {
        String[] timeSplit = time.split(":");
        int h = Integer.parseInt(timeSplit[0]) * 60;
        int m = Integer.parseInt(timeSplit[1]);

        return h + m;
    }
}