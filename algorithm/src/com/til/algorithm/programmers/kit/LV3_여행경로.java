package com.til.algorithm.programmers.kit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LV3_여행경로 {

    private List<String> airport = new ArrayList<>();
    private boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, 0, "ICN", "ICN");
        Collections.sort(airport);
        return airport.get(0).split(" ");
    }

    private void dfs(String[][] tickets, int depth, String curr, String path) {
        if (depth == tickets.length) {
            airport.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && curr.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, depth + 1, tickets[i][1], path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
