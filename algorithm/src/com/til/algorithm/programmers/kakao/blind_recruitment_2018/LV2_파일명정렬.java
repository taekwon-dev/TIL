package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.Arrays;

public class LV2_파일명정렬 {

    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String s1 = o1.split("[0-9]")[0];
            String s2 = o2.split("[0-9]")[0];
            int result = s1.toLowerCase().compareTo(s2.toLowerCase());
            if (result == 0) {
                result = findNumber(o1, s1) - findNumber(o2, s2);
            }
            return result;
        });
        return files;
    }

    private int findNumber(String origin, String head) {
        origin = origin.replace(head, "");
        StringBuilder number = new StringBuilder();
        for (char c : origin.toCharArray()) {
            if (Character.isDigit(c) && number.length() < 5) {
                number.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(number.toString());
    }
}