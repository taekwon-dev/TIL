package com.til.algorithm.programmers.graph_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Youn on 2022/05/09.
 * Title : 여행경로 (https://programmers.co.kr/learn/courses/30/lessons/43164)
 * Hint  :
 */
public class 여행경로 {

    static boolean[] visited;
    static List<String> resultList;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "AFK"}, {"HND", "AAD"}, {"AFK", "HND"}};
        String result[] = solution(tickets);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];
        resultList = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(resultList);
        answer = resultList.get(0).split(" ");
        return answer;
    }

    private static void dfs(String start, String route, String[][] tickets, int index) {
        if (index == tickets.length) {
            resultList.add(route);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, index+1);
                visited[i] = false;
            }
        }



    }
}
