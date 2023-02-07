package com.til.algorithm.algorithm.queue;

import java.util.Stack;

public class 두_스택을_활용한_큐<T> {

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    private void moveIfAbsent() {
        if (stack2.isEmpty()) {
            while (stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public void add(T t) {
        stack1.push(t);
    }

    public T poll() {
        moveIfAbsent();
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}