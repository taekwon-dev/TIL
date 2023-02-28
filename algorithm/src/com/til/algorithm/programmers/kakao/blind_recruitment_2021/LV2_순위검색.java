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
            String[] rowSplit = q.split(" ");
            String key = rowSplit[0];
            int standard = Integer.parseInt(rowSplit[1]);
            if (map.containsKey(key)) {
                answer[i] = binarySearch(key, standard);
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
            int score = Integer.parseInt(rowSplit[4]);
            map.get(s).add(score);
            return;
        }
        backtracking(rowSplit, depth + 1, s + rowSplit[depth]);
        backtracking(rowSplit, depth + 1, s + "-");
    }

    private int binarySearch(String key, int standard) {
        List<Integer> scores = map.get(key);
        int low = 0;
        int high = scores.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (scores.get(mid) < standard) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return scores.size() - low;
    }
}