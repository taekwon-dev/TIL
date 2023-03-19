package com.til.algorithm.java.data_structure.queue;

public class Node<E> {

    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
