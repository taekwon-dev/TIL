package com.til.algorithm.ds.queue;

import java.util.Stack;

/**
 *  두 개의 Stack 을 통해 Queue 의 enqueue, dequeue 구현하기
 */
public class QueueImpl {

    private static Stack<Integer> tmp;
    private static Stack<Integer> target;

    public static void main(String[] args) {
        tmp = new Stack<>();
        target = new Stack<>();

        enqueue(1);
        enqueue(2);
        enqueue(3);

        System.out.println(dequeue()); // 1
        System.out.println(dequeue()); // 2
        System.out.println(dequeue()); // 3
    }

    private static void enqueue(int num) {
        tmp.push(num);
    }

    private static int dequeue() {
        int popped = -1;

        if (target.isEmpty()) {
            while (!tmp.isEmpty()) {
                target.push(tmp.pop());
            }
            popped = target.pop();
        }
        if (!target.isEmpty()) {
            while (!target.isEmpty()) {
                tmp.push(target.pop());
            }
        }
        return popped;
    }
}
