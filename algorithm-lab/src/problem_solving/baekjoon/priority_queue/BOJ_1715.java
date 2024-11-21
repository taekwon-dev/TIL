package problem_solving.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class BOJ_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (n == 1) {
            System.out.println(0); // 비교 횟수 0
            return;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int min1 = pq.poll();
            int min2 = pq.poll();

            answer += min1 + min2;
            if (pq.isEmpty()) {
                continue;
            }
            pq.offer(min1 + min2);
        }
        System.out.println(answer);
    }
}