package com.til.algorithm.java.data_structure;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {

        private Object data;
        private Node next;
        private Node prev;

        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node node = new Node(input);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
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
        node.prev = tail;
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
        if (target != null) {
            target.prev = node;
        }
        node.prev = prev;
        size++;
        if (node.next == null) {
            tail = node;
        }
    }

    /**
     *  인덱스의 위치에 따라서 탐색 방향을 달리할 수 있고, 이를 통해 탐색 시간을 약 두 배 향상 시킬 수 있다.
     */
    private Node node(int index) {
        if (index < size / 2) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        Node node = tail;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        return node;
    }
}