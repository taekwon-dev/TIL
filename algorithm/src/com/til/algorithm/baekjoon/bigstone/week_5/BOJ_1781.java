package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {

    static class Question {
        int deadline;
        int cup;

        public Question(int deadline, int cup) {
            this.deadline = deadline;
            this.cup = cup;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Question[] questions = new Question[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            questions[i] = new Question(deadline, cup);
        }
        Arrays.sort(questions, (q1, q2) -> {
            if (q1.deadline == q2.deadline) {
                return q2.cup - q1.cup;
            }
            return q1.deadline - q2.deadline;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Question question : questions) {
            if (pq.size() < question.deadline) {
                pq.offer(question.cup);
                continue;
            }
            if (pq.size() == question.deadline) {
                if (pq.peek() < question.cup) {
                    pq.poll();
                    pq.offer(question.cup);
                }
            }
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}