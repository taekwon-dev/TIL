package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

import java.util.HashMap;
import java.util.ArrayList;

public class LV1_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            String[] termSplit = term.split(" ");
            String type = termSplit[0];
            int warrancy = Integer.parseInt(termSplit[1]);
            map.put(type, warrancy);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int todayHashCode = hashCode(today, 0);
        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            String targetDate = privacySplit[0];
            String targetType = privacySplit[1];
            int targetWarrancy = map.get(targetType);
            int targetHashCode = hashCode(targetDate, targetWarrancy) - 1;

            if (todayHashCode > targetHashCode) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private int hashCode(String date, int warrancyMonth) {
        String[] dateSplit = date.split("\\.");

        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]) + warrancyMonth;
        int day = Integer.parseInt(dateSplit[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}