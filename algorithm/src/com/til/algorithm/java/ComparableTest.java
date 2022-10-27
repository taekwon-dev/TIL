package com.til.algorithm.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    static class Node implements Comparable<Node> {

        int age;
        int money;

        public Node(int age, int money) {
            this.age = age;
            this.money = money;
        }

        public int getAge() {
            return age;
        }

        public int getMoney() {
            return money;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "age=" + age +
                    ", money=" + money +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (this.age > o.age) {
                return 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(10, 100));
        nodes.add(new Node(5, 50));
        nodes.add(new Node(30, 3));
        nodes.add(new Node(1, 1000));
        nodes.add(new Node(1, 2000));

        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println();
        Collections.sort(nodes);
        System.out.println();
        for (Node node : nodes) {
            System.out.println(node);
        }
    }
}
