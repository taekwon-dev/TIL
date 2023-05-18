package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *  0
 *  1
 *  2
 *  3
 *  0 1
 *  0 2
 *  0 3
 *  1 2
 *  1 3
 *  2 3
 *  0 1 2
 *  0 1 3
 *  0 2 3
 *  1 2 3
 *  0 1 2 3
 *
 *  최소성 만족 여부를 검증하기 위해서는 키를 구성하는 컬럼의 수가 작은 것부터 검증해야 한다.
 */
public class LV2_후보키 {

    private String[][] relation;
    private int[] idx;
    private HashSet<String> set;
    private ArrayList<String> candidate = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;

        for (int i = 1; i <= relation[0].length; i++) {
            idx = new int[i];
            backtracking(0, 0, i);
        }
        return candidate.size();
    }

    private void backtracking(int col, int start, int end) {
        if (col == end) {
            set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < idx.length; j++) {
                    key.append(relation[i][idx[j]]);
                }
                if (set.contains(key.toString())) {
                    return;
                }
                set.add(key.toString());
            }
            StringBuilder keyIdx = new StringBuilder();
            for (int i = 0; i < idx.length; i++) {
                keyIdx.append(idx[i]);
            }
            if (candidate.isEmpty()) {
                candidate.add(keyIdx.toString());
                return;
            }
            for (String s : candidate) {
                int cnt = 0;
                for (int i = 0; i < keyIdx.length(); i++) {
                    String target = String.valueOf(keyIdx.charAt(i));
                    if (s.contains(target)) {
                        cnt++;
                    }
                }
                if (cnt == s.length()) {
                    return;
                }
            }
            candidate.add(keyIdx.toString());
            return;
        }
        for (int i = start; i < relation[0].length; i++) {
            idx[col] = i;
            backtracking(col + 1, i + 1, end);
        }
    }
}