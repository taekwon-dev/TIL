package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_순위검색 {

    private HashMap<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            backtracking(infos, 0, "");
        }
        List<String> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Collections.sort(map.get(keys.get(i)));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String s = query[i].replace(" and ", "");
            String[] querySplit = s.split(" ");
            String key = querySplit[0];
            int score = Integer.parseInt(querySplit[1]);
            if (!map.containsKey(key)) {
                answer[i] = 0;
            } else {
                answer[i] = binarySearch(key, score);
            }
        }
        return answer;
    }

    private void backtracking(String[] infos, int depth, String s) {
        if (depth == infos.length - 1) {
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            int score = Integer.parseInt(infos[4]);
            map.get(s).add(score);
            return;
        }
        backtracking(infos, depth + 1, s + infos[depth]);
        backtracking(infos, depth + 1, s + "-");
    }

    private int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int l = 0;
        int r = scores.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (scores.get(mid) < score) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return scores.size() - l;
    }
}
