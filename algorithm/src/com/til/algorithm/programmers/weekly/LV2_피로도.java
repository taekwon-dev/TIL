package com.til.algorithm.programmers.weekly;

/**
 * Created by Youn on 2022/06/18.
 * Title : 피로도 (https://programmers.co.kr/learn/courses/30/lessons/87946)
 * Hint  : Backtracking
 */
public class LV2_피로도 {
    public boolean[] visited;
    public int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int count, int k, int[][] dungeons) {

        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(count + 1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}
