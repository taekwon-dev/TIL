package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.HashSet;

public class LV2_후보키 {

    private int[] candidate;
    private String[][] relation;
    private HashSet<String> tuple = new HashSet<>();
    private ArrayList<String> answer = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        for (int i = 1; i <= relation[0].length; i++) {
            candidate = new int[i];
            backtracking(0, 0, i);
        }
        return answer.size();
    }

    private void backtracking(int idx, int start, int end) {
        if (idx == end) {
            tuple = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < candidate.length; j++) {
                    sb.append(relation[i][candidate[j]]);
                }
                if (tuple.contains(sb.toString())) {
                    return;
                }
                tuple.add(sb.toString());
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < candidate.length; i++) {
                key.append(candidate[i]);
            }

            for (String s : answer) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String index = String.valueOf(key.charAt(i));
                    if (s.contains(index)) {
                        count++;
                    }
                }
                if (count == s.length()) {
                    return;
                }
            }
            answer.add(key.toString());
            return;
        }
        for (int i = start; i < relation[0].length; i++) {
            candidate[idx] = i;
            backtracking(idx + 1, i + 1, end);
        }
    }
}