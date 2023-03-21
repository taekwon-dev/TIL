package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LV2_후보키 {

    private List<String> candidates = new ArrayList<>();
    private String[][] relation;
    private boolean[] visited;

    public int solution(String[][] relation) {
        this.relation = relation;
        for (int i = 0; i < relation[0].length; i++) {
            visited = new boolean[relation[0].length];
            backtracking(0, 0, i + 1);
        }
        return candidates.size();
    }

    /**
     *  기존 백트랙킹 + 조합 문제에서는 조합을 통해 얻은 결과를 특정 순서에 맞게 진행할 필요가 없었는데,
     *  이 문제에서는 DB 최소성 개념에 맞추기 위해 특정 순서에 맞게 풀이를 전개해야 했다.
     *
     *  0 -> 1 -> 2 -> 3 (한 개 컬럼)
     *  01 -> 02 -> 03 -> 12 -> 13 -> 23 (두 개 컬럼)
     *
     *  위와 같은 순서대로 차례대로 전개해야 유일성을 만족하면서 최소성까지 만족하는지를 논리적으로 탐색할 수 있다.
     *  따라서 백트랙킹 시 `end` 파라미터 값을 기준으로 종료할 시점을 정해서 전개하는 방식을 볼 수 있다.
     */
    private void backtracking(int depth, int start, int end) {
        if (depth == end) {
            List<Integer> indices = new ArrayList<>();
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key.append(i);
                    indices.add(i);
                }
            }

            Set<String> set = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder record = new StringBuilder();
                for (int index : indices) {
                    record.append(relation[i][index]);
                }
                if (set.contains(record.toString())) {
                    return;
                }
                set.add(record.toString());
            }

            for (String candidate : candidates) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String s = String.valueOf(key.charAt(i));
                    if (candidate.contains(s)) {
                        count++;
                    }
                }
                if (count == candidate.length()) {
                    return;
                }
            }
            candidates.add(key.toString());
            return;
        }
        for (int i = start; i < relation[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1, end);
                visited[i] = false;
            }
        }
    }
}