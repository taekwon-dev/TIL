package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.*;

public class LV2_순위검색 {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for (String row : info) {
            String[] strs = row.split(" ");
            backtracking(strs, "", 0);
        }
        Iterator<Map.Entry<String, List<Integer>>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Collections.sort(iter.next().getValue());
        }
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String s = query[i].replace(" and ", "");
            String[] strs = s.split(" ");
            answer[i] = map.containsKey(strs[0]) ? binarySearch(strs[0], Integer.valueOf(strs[1])) : 0;
        }
        return answer;
    }

    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }

    private void backtracking(String[] strs, String s, int depth) {
        if (depth == 4) {
            if (!map.containsKey(s)) {
                List<Integer> list = new ArrayList<>();
                map.put(s, list);
            }
            map.get(s).add(Integer.valueOf(strs[4]));
            return;
        }
        backtracking(strs, s + "-", depth + 1);
        backtracking(strs, s + strs[depth], depth + 1);
    }
}
