package problem_solving.baekjoon.priority_queue;

import java.util.*;
import java.io.*;

public class BOJ_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
            if (node1.absoluteValue == node2.absoluteValue) {
                return node1.actualValue - node2.actualValue;
            }
            return node1.absoluteValue - node2.absoluteValue;
        });

        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(sc.nextLine());
            if (request != 0) {
                pq.offer(new Node(Math.abs(request), request));
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll().actualValue);
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    static class Node {
        int absoluteValue;
        int actualValue;

        public Node(int absoluteValue, int actualValue) {
            this.absoluteValue = absoluteValue;
            this.actualValue = actualValue;
        }
    }
}