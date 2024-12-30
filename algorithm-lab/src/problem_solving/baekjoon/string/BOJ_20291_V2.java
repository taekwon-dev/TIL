package problem_solving.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291_V2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        while (N-- > 0) {
            String exe = br.readLine().split("\\.")[1];
            map.put(exe, map.getOrDefault(exe, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());

        StringBuilder answer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            answer.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(answer);
    }
}
