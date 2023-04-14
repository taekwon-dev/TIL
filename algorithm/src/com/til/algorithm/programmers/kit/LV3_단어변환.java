package com.til.algorithm.programmers.kit;

public class LV3_단어변환 {

    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (compare(begin, words[i]) <= 1) {
                visited = new boolean[words.length];
                visited[i] = true;
                backtracking(1, i, target, words);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void backtracking(int cnt, int idx, String target, String[] words) {
        if (target.equals(words[idx])) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && compare(words[idx], words[i]) == 1) {
                visited[i] = true;
                backtracking(cnt + 1, i, target, words);
                visited[i] = false;
            }
        }
    }

    private int compare(String s1, String s2) {
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}