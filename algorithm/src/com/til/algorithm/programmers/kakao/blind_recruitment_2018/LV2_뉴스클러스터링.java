package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.ArrayList;
import java.util.List;

public class LV2_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        List<String> str1List = sliceByTwo(str1.toLowerCase());
        List<String> str2List = sliceByTwo(str2.toLowerCase());

        if (str1List.size() == 0 && str2List.size() == 0) {
            return 65536;
        }
        int str1ListSize = str1List.size();
        int str2ListSize = str2List.size();
        int intersectionSize = 0;

        for (int i = 0; i < str1ListSize; i++) {
            for (int j = 0; j < str2List.size(); j++) {
                if (str1List.get(i).equals(str2List.get(j))) {
                    intersectionSize++;
                    str2List.remove(j);
                    break;
                }
            }
        }
        double unionSize = (str1ListSize + str2ListSize) - intersectionSize;
        int answer = (int) Math.floor((intersectionSize / unionSize) * 65536);
        return answer;
    }

    private List<String> sliceByTwo(String s) {
        List<String> sliced = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = s.substring(i, i + 2).replaceAll("[^a-z]", "");
            if (tmp.length() < 2) {
                continue;
            }
            sliced.add(tmp);
        }
        return sliced;
    }
}
