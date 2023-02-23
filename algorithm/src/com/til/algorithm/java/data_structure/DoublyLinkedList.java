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
     *  (한 노드를 기준으로 양방향 탐색이 가능하기 때문에, 더 가까운 쪽을 기준으로 대상 노드를 탐색할 수 있다)
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

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return returnData;
    }

    public Object remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        Node prev = node(index - 1);
        Node target = prev.next;
        prev.next = prev.next.next;
        if (prev.next != null) {
            prev.next.prev = prev;
        }
        Object returnData = target.data;
        if (target == tail) {
            tail = prev;
        }
        target = null;
        size--;
        return returnData;
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public Object get(int index) {
        return node(index);
    }

    public int indexOf(Object data) {
        Node node = head;
        int index = 0;
        while (node.data != data) {
            node = node.next;
            index++;
            if (node == null) {
                return -1;
            }
        }
        return index;
    }
}