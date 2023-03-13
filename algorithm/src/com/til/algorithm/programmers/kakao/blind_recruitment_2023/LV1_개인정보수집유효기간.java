package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

import java.util.ArrayList;
import java.util.HashMap;

public class LV1_개인정보수집유효기간 {

    private HashMap<String, String> expiration = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            expiration.put(termSplit[0], termSplit[1]);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int index = 1;
        for (String privacy : privacies) {
            String[] privacySplit = privacy.split(" ");
            String date = privacySplit[0];
            String type = privacySplit[1];
            int duration = Integer.parseInt(expiration.get(type));

            int todayHashCode = hashCode(today, 0);
            int targetHashCode = hashCode(date, duration) - 1;

            if (todayHashCode > targetHashCode) {
                answer.add(index);
            }
            index++;
        }
        /**
         *  List<Integer> to int[]
         */
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int hashCode(String date, int duration) {
        String[] dateSplit = date.split("\\.");
        int year = Integer.parseInt(dateSplit[0]) * 12 * 28;
        int month = (Integer.parseInt(dateSplit[1]) + duration) * 28;
        int day = Integer.parseInt(dateSplit[2]);

        return year + month + day;
    }
}