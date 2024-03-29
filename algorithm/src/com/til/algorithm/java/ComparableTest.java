package com.til.algorithm.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *       1  (1) : Swap!
 *     /
 *   7 − 7  (0)
 *     \
 *       9  (-1) : ~Swap! (자바는 기본적으로 오름차순을 적용, 따라서 비교 결과가 음수가 나오는 경우 교환 X)
 *
 *   객체 정렬 시, 객체의 어떤 값을 기준으로 정렬할 지 결정하기 위해 Comparable 인터페이스 구현!
 */
public class ComparableTest {

    static class Node implements Comparable<Node> {

        private int age;
        private int height;

        public Node(int age, int height) {
            this.age = age;
            this.height = height;
        }

        /**
         *  나이 순 정렬 (오름차순) 단, 나이가 같다면 키 순 정렬 (오름차순)
         */
        @Override
        public int compareTo(Node o) {
            if (this.age == o.age) {
                return this.height - o.height;
            }
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "age = " + this.age + " height = " + this.height;
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Node(3, 300));
        nodes.add(new Node(1, 100));
        nodes.add(new Node(3, 30));
        nodes.add(new Node(3, 3000));
        nodes.add(new Node(2, 200));

        /**
         *  Node 클래스 정렬 기준 적용된 상태로 정렬 처리
         */
        Collections.sort(nodes);

        /**
         *  age = 1 height = 100
         *  age = 2 height = 200
         *  age = 3 height = 30
         *  age = 3 height = 300
         *  age = 3 height = 3000
         */
        for (Node node : nodes) {
            System.out.println(node);
        }
    }
}