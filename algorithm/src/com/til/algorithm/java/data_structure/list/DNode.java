package com.til.algorithm.java.data_structure.list;

public class DNode<E> {

    E data;
    DNode<E> prev;
    DNode<E> next;

    public DNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}