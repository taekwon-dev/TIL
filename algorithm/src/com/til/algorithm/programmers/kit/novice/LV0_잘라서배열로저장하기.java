package com.til.algorithm.programmers.kit.novice;

public class LV0_잘라서배열로저장하기 {
    public String[] solution(String my_str, int n) {
        int len = (int) Math.ceil(my_str.length() / (double) n);
        String[] answer = new String[len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                answer[i] = my_str.substring(idx);
                break;
            }
            answer[i] = my_str.substring(idx, idx + n);
            idx += n;
        }
        return answer;
    }
}
