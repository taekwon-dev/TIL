package com.til.algorithm.java.data_structure.tree.binary_tree;

public class Node<E> {

    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E value) {
        this(value, null);
    }

    public Node(E value, Node<E> parent) {
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}