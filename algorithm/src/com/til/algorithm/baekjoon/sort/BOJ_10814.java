package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Arrays;

import java.util.StringTokenizer;

public class BOJ_10814 {

    static class Member implements Comparable<Member> {

        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(age, name);
        }

        Arrays.sort(members);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            answer.append(members[i].age + " " + members[i].name).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}