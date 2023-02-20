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

    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        Node temp = node(index - 1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object retrunData = todoDeleted.data;
        if (todoDeleted == tail) {
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return retrunData;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node temp = node(index);
        return temp.data;
    }

    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;
        while (temp.data != data) {
            temp = temp.next;
            index++;
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }
}