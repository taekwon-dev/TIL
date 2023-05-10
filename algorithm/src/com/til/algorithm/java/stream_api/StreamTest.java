package com.til.algorithm.java.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    
    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("s1", 80);
        Student s2 = new Student("s2", 85);
        Student s3 = new Student("s3", 90);
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Stream<Student> studentStream = students.stream();
        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
        double avg = students.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();
        System.out.println("avg = " + avg);
    }
}
