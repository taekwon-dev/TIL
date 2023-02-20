package com.til.algorithm.programmers.kakao.blind_recruitment_2023;

import java.util.ArrayList;
import java.util.HashMap;

public class LV1_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, String> map = new HashMap<>();
        for (String term : terms) {
            String[] termSplit = term.split(" ");
            map.put(termSplit[0], termSplit[1]);
        }
        Integer idx = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (String privacy : privacies) {
            String[] privacySplit = privacy.split(" ");
            String date = privacySplit[0];
            String type = privacySplit[1];
            int duration = Integer.parseInt(map.get(type));

            int privacyExpTotalDate = getTotalDate(date, duration) - 1;
            int todayTotalDate = getTotalDate(today, 0);

            if (privacyExpTotalDate < todayTotalDate) {
                result.add(idx);
            }
            idx++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getTotalDate(String target, int duration) {
        String[] dateSplit = target.split("\\.");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]) + duration;
        int day = Integer.parseInt(dateSplit[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}