package problem_solving.baekjoon.string;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Key 값 기준으로 별도의 정렬 없이도 오름차순으로 저장할 수 있는 TreeMap(Red Black Tree 기반) 구현체 활용
 */
public class BOJ_20291_V1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        while (N-- > 0) {
            String exe = br.readLine().split("\\.")[1];
            map.put(exe, map.getOrDefault(exe, 0) + 1);
        }
        StringBuilder answer = new StringBuilder();
        map.forEach((k, v) -> answer.append(k).append(" ").append(v).append("\n"));

        System.out.println(answer);
    }
}
