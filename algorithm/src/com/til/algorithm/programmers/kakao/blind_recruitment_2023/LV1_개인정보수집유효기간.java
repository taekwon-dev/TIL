package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

import java.util.HashMap;
import java.util.ArrayList;

public class LV1_개인정보수집유효기간 {

    private HashMap<String, Integer> termMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termMap.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }

        ArrayList<Integer> indices = new ArrayList<>();
        int index = 1;
        for (String privacy : privacies) {
            String[] privacySplit = privacy.split(" ");
            String date = privacySplit[0];
            String term = privacySplit[1];

            int todayHashCode = hashCode(today, 0);
            int targetHashCode = hashCode(date, termMap.get(term)) - 1;

            if (todayHashCode > targetHashCode) {
                indices.add(index);
            }
            index++;
        }
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    private int hashCode(String date, int term) {
        String[] dateSplit = date.split("\\.");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]) + term;
        int day = Integer.parseInt(dateSplit[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}