package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825 {

    static class Student implements Comparable<Student> {

        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                if (this.english == o.english) {
                    if (this.math == o.math) {
                        // 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                        return this.name.compareTo(o.name);
                    }
                    // 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                    return o.math - this.math;
                }
                // 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
                return this.english - o.english;
            }
            // 1. 국어 점수가 감소하는 순서로
            return o.korean - this.korean;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(students);

        StringBuilder answer = new StringBuilder();
        for (Student student : students) {
            answer.append(student.name).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}