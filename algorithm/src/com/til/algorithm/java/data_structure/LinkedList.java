package com.til.algorithm.java.data_structure;

public class LinkedList {

    private class Node {

        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
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
        /**
         *  새로 추가한 노드의 다음 노드가 없는 경우, 새로 추가한 노드를 꼬리로 지정
         */
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node node = new Node(input);
        /**
         *  연결 리스트 사이즈가 0인 경우, addFirst()
         */
        if (size == 0) {
            addFirst(input);
            return;
        }
        /**
         *  연결 리스트의 꼬리의 다음 노드로 지정
         */
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int index, Object input) {
        /**
         *  인덱스가 0인 경우, addFirst()
         */
        if (index == 0) {
            addFirst(input);
            return;
        }
        /**
         *  연결 리스트 노드 사이에 새로우 노드를 추가하는 경우
         */
        Node prev = node(index - 1); // 타겟 인덱스 - 1 위치한 노드
        Node target = prev.next;           // 타겟 인덱스에 위치한 노드

        Node node = new Node(input);
        prev.next = node;                 // 타겟 인덱스 - 1 위치한 노드의 다음 노드로 새로운 노드 지정
        node.next = target;               // 새로운 노드 다음 노드로 타겟 인덱스에 위치한 노드 지정
        size++;
        /**
         *  새로운 노드 다음 (= 타겟 인덱스에 위치한 노드)가 NULL인 경우
         *  새로운 노드를 꼬리로 지정
         */
        if (node.next == null) {
            tail = node;
        }
    }

    /**
     *  주어진 인덱스에 위치한 노드 반환 (탐색)
     */
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
        Node target = temp.next;
        temp.next = temp.next.next;
        Object retrunData = target.data;
        if (target == tail) {
            tail = temp;
        }
        target = null;
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
            /**
             *  연결 리스트 내부에 타겟 노드가 없는 경우, -1 반환
             */
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }
}