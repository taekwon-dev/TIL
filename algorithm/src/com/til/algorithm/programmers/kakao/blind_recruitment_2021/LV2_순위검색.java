package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_순위검색 {

    private HashMap<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String row : info) {
            String[] rowSplit = row.split(" ");
            backtracking(rowSplit, 0, "");
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", "");
            String[] querySplit = q.split(" ");
            if (map.containsKey(querySplit[0])) {
                answer[i] = binarySearch(querySplit[0], Integer.parseInt(querySplit[1]));
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private void backtracking(String[] rowSplit, int depth, String s) {
        if (depth == 4) {
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(Integer.parseInt(rowSplit[4]));
            return;
        }
        backtracking(rowSplit, depth + 1, s + "-");
        backtracking(rowSplit, depth + 1, s + rowSplit[depth]);
    }

    private int binarySearch(String combination, int score) {
        List<Integer> scores = map.get(combination);
        int start = 0;
        int end = scores.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return scores.size() - start;
    }
}
