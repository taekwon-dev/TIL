package com.til.algorithm.java.data_structure.queue;

import java.util.Comparator;

public class PriorityQueue<E> implements Queue<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public PriorityQueue(int capacity) {
        this(capacity, null);
    }

    public PriorityQueue(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeftChild(int index) {
        return index * 2;
    }

    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }
        this.array = null;
        this.array = newArray;
    }

    @Override
    public boolean offer(E item) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
