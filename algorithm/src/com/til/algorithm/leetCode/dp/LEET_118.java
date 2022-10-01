package com.til.algorithm.leetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class LEET_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);

        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                int next = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                list.add(next);
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Node n11 = new Node(1, 1);
        System.out.println("n11.hashCode() = " + n11.hashCode());
        Node n12 = new Node(1, 2);
        System.out.println("n12.hashCode() = " + n12.hashCode());
    }
}
