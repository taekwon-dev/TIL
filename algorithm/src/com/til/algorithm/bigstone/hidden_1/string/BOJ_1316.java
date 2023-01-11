package com.til.algorithm.bigstone.hidden_1.string;

import java.io.*;

public class BOJ_1316 {

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            visited = new boolean[26];
            if (isGroupWord(br.readLine())) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isGroupWord(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (visited[word.charAt(j) - 'a']) {
                    return false;
                }
                if (word.charAt(i) == word.charAt(j)) {
                    continue;
                }
                visited[word.charAt(i) - 'a'] = true;
                i = j;
            }
        }
        return true;
    }
}