package com.til.algorithm.programmers.kakao.tech_internship_2019;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class LV3_불량사용자 {

    private String[] userId;
    private String[] bannedId;
    private boolean[] visited;
    private HashSet<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        visited = new boolean[userId.length];

        for (int i = 0; i < bannedId.length; i++) {
            bannedId[i] = bannedId[i].replace("*", ".");
        }
        backtracking(0, "");
        return set.size();
    }

    private void backtracking(int depth, String candidate) {
        if (depth == bannedId.length) {
            String[] candidateSplit = candidate.split(" ");
            Arrays.sort(candidateSplit);

            StringBuilder sb = new StringBuilder();
            for (String name : candidateSplit) {
                sb.append(name);
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < userId.length; i++) {
            if (!visited[i] && userId[i].matches(bannedId[depth])) {
                visited[i] = true;
                backtracking(depth + 1, candidate + userId[i] + " ");
                visited[i] = false;
            }
        }
    }
}