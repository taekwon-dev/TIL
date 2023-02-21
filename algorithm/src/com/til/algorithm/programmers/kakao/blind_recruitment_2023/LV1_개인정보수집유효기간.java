package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

import java.util.ArrayList;
import java.util.HashMap;

public class LV1_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, String> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], temp[1]);
        }
        int todayTotalDate = getTotalDate(today);
        ArrayList<Integer> expiration = new ArrayList<>();
        int idx = 1;
        for (String privacy : privacies) {
            String[] temp = privacy.split(" ");
            String date = temp[0];
            String type = temp[1];
            int period = Integer.parseInt(map.get(type)) * 28;
            int validation = getTotalDate(date) + period - 1;
            if (validation < todayTotalDate) {
                expiration.add(idx);
            }
            idx++;
        }
        return expiration.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getTotalDate(String date) {
        String[] temp = date.split("\\.");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}