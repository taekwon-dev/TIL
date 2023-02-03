package com.til.algorithm.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐를_활용한_스택<T> {

    Queue<T> main = new LinkedList<>();
    Queue<T> sub = new LinkedList<>();

    public void push(T t) {
        main.offer(t);
    }

    public T pop() {
        T popped = null;
        if (main.isEmpty()) {
            return null;
        }
        while (main.size() != 1) {
            sub.offer(main.poll());
        }
        popped = main.poll();

        while (!sub.isEmpty()) {
            main.offer(sub.poll());
        }
        return popped;
    }

    public static void main(String[] args) {
        두_큐를_활용한_스택<Integer> obj = new 두_큐를_활용한_스택<>();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        System.out.println(obj.pop()); // 3
        System.out.println(obj.pop()); // 2
        System.out.println(obj.pop()); // 1
    }
}