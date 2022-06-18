package com.til.algorithm.programmers.weekly;

/**
 * Created by Youn on 2022/06/18.
 * Title : 모음사전 (https://programmers.co.kr/learn/courses/30/lessons/84512)
 * Hint  : Debug Mode (AAAAA -> AAAAE -> AAAAI -> ...)
 */
public class LV2_모음사전_Test {

    public static int count = 0, answer = 0;
    public static String[] dicts = {"A", "E", "I", "O", "U"};
    public static String word = "EIO";

    public static void main(String[] args) {
        dfs("", word);
        System.out.println(answer);
    }

    public static void dfs(String curr, String word) {
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
