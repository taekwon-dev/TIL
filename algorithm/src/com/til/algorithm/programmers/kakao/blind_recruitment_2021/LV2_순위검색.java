package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_순위검색 {

    private Map<String, List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (int i = 0; i < info.length; i++) {
            String[] infoSplit = info[i].split(" ");
            backtracking(0, infoSplit, "");
        }

        /**
         *  Binary Search 알고리즘을 활용하기 위해 각 리스트를 오름차순으로 정렬
         */
        for (String key : db.keySet()) {
            Collections.sort(db.get(key));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] querySplit = query[i].split(" ");

            String targetKey = querySplit[0];
            int targetScore = Integer.parseInt(querySplit[1]);

            if (!db.containsKey(targetKey)) {
                answer[i] = 0;
            } else {
                answer[i] = binarySearch(targetKey, targetScore);
            }
        }
        return answer;
    }

    private void backtracking(int depth, String[] infoSplit, String key) {
        if (depth == infoSplit.length - 1) {
            if (!db.containsKey(key)) {
                db.put(key, new ArrayList<>());
            }
            int score = Integer.parseInt(infoSplit[4]);
            db.get(key).add(score);
            return;
        }
        backtracking(depth + 1, infoSplit, key + infoSplit[depth]);
        backtracking(depth + 1, infoSplit, key + '-');
    }

    /**
     *   Binary Search 알고리즘을 활용해 리스트 내 타겟 점수 이상인 요소가 몇 개인지 탐색
     */
    private int binarySearch(String targetKey, int targetScore) {
        List<Integer> scores = db.get(targetKey);

        int left = 0;
        int right = scores.size() - 1;

        while (left <= right) {
            int mid = (left + right ) / 2;
            if (scores.get(mid) < targetScore) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return scores.size() - 1 - right;
    }
}