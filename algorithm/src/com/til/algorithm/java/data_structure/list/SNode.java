package com.til.algorithm.java.data_structure.list;

public class SNode<E> {

    E data;
    SNode<E> next;

    public SNode(E data) {
        this.data = data;
        this.next = null;
    }
}