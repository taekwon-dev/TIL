package problem_solving.baekjoon.string;

import java.util.*;
import java.io.*;

public class BOJ_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();

        while (n-- > 0) {
            wordSet.add(br.readLine());
        }

        List<String> words = new ArrayList<>(wordSet);
        words.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return Integer.compare(s1.length(), s2.length());
        });

        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            answer.append(word).append("\n");
        }

        System.out.println(answer);
    }
}
