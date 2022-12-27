package com.til.algorithm.baekjoon.bigstone.hidden_1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        int n = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>(n);
        StringTokenizer st = null;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(members);
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
