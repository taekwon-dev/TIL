package com.til.algorithm.programmers.kakao.tech_internship_2019;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class LV3_불량사용자 {

    private Set<String> answer = new HashSet<>();
    private String[] userIds;
    private String[] banIds;
    private boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        banIds = banned_id;
        visited = new boolean[user_id.length];

        for (int i = 0; i < banIds.length; i++) {
            banIds[i] = banIds[i].replace("*", ".");
        }
        backtracking(0, "");

        return answer.size();
    }

    private void backtracking(int depth, String candidate) {
        if (depth == banIds.length) {
            String[] candidateSplit = candidate.split(" ");
            Arrays.sort(candidateSplit);
            StringBuilder sb = new StringBuilder();
            for (String id : candidateSplit) {
                sb.append(id);
            }
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < userIds.length; i++) {
            if (!visited[i] && userIds[i].matches(banIds[depth])) {
                visited[i] = true;
                backtracking(depth + 1, candidate + " " + userIds[i]);
                visited[i] = false;
            }
        }
    }
}