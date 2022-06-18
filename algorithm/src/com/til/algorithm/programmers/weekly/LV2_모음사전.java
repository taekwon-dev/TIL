package com.til.algorithm.programmers.weekly;

/**
 * Created by Youn on 2022/06/18.
 * Title : 모음사전 (https://programmers.co.kr/learn/courses/30/lessons/84512)
 * Hint  :
 */
public class LV2_모음사전 {
    public int count = 0, answer = 0;
    public String[] dicts = {"A", "E", "I", "O", "U"};
    public int solution(String word) {

        dfs("", word);
        return answer;
    }

    public void dfs(String curr, String word) {
        if (curr.length() == 5 || curr.equals(word)) {
            if (curr.equals(word)) {
                answer = count;
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            count += 1;
            dfs(curr + dicts[i], word);
        }
    }
}
