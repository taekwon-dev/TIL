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
        ArrayList<Integer> answer = new ArrayList<>();
        int todayHashCode = hashCode(today, 0);
        int idx = 1;
        for (String privacy : privacies) {
            String[] privacySplit = privacy.split(" ");
            String date = privacySplit[0];
            int validation = Integer.parseInt(map.get(privacySplit[1]));
            int targetHashCode = hashCode(date, validation) - 1;

            if (todayHashCode > targetHashCode) {
                answer.add(idx);
            }
            idx++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int hashCode(String date, int validation) {
        String[] dateSplit = date.split("\\.");
        int year = Integer.parseInt(dateSplit[0]) * 12 * 28;
        int month = (Integer.parseInt(dateSplit[1]) + validation) * 28;
        int day = Integer.parseInt(dateSplit[2]);

        return year + month + day;
    }
}