package com.til.algorithm.programmers.kit;

import java.util.HashSet;
import java.util.Set;

public class LV2_전화번호목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }
        boolean answer = true;
        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length() - 1; i++) {
                if (set.contains(phone.substring(0, i))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}
