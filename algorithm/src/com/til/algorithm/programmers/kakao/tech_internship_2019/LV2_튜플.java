package com.til.algorithm.programmers.kakao.tech_internship_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LV2_튜플 {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] strs = s.split("},\\{");

        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());

        for (String str : strs) {
            String[] temp = str.split(",");
            for (int i = 0; i < temp.length; i++) {
                int num = Integer.valueOf(temp[i]);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        return answer;
    }
}
