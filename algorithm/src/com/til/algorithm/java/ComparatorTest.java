package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class ComparatorTest {

    @Test
    @DisplayName("Integer 오름차순")
    void ascendingInteger() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 7, 5, 9));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        list.equals(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
    }

    @Test
    @DisplayName("Integer 내림차순")
    void descendingInteger() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 7, 5, 9));
        Collections.sort(list, (o1, o2) -> o2 - o1);
        list.equals(new ArrayList<>(Arrays.asList(9, 7, 5, 3, 1)));
    }

    @Test
    @DisplayName("Student 점수 기준 내림차순 (점수가 같으면 ID 기준 오름차순)")
    void studentSort() {
        class Student {
            int id;
            int score;
            
            public Student(int id, int score) {
                this.id = id;
                this.score = score;
            }
        }
        Student st1 = new Student(1, 50);
        Student st2 = new Student(2, 20);
        Student st3 = new Student(3, 30);
        Student st4 = new Student(4, 30);
        Student st5 = new Student(5, 10);
        
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        
        Collections.sort(students, (s1, s2) -> {
            if (s1.score == s2.score) {
                return s1.id - s2.id;
            }
            return s2.score - s1.score;
        });

        /**
         * SCORE : 50 ID : 1
         * SCORE : 30 ID : 3
         * SCORE : 30 ID : 4
         * SCORE : 20 ID : 2
         * SCORE : 10 ID : 5
         */
        for (Student student : students) {
            System.out.println("SCORE : " + student.score + " ID : " + student.id);
        }
    }



}
