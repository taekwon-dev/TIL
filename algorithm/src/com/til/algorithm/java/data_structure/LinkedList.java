package com.til.algorithm.java.data_structure;

public class LinkedList {

    private class Node {

        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(Object input) {
        Node node = new Node(input);
        node.next = head;
        head = node;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node node = new Node(input);
        if (size == 0) {
            addFirst(input);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int index, Object input) {
        if (index == 0) {
            addFirst(input);
            return;
        }
        Node prev = node(index - 1);
        Node target = prev.next;
        Node node = new Node(input);
        prev.next = node;
        node.next = target;
        size++;
        if (node.next == null) {
            tail = node;
        }
    }

    private Node node(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}