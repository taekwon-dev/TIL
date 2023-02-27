package com.til.algorithm.java.data_structure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }
        int arrayCapacity = array.length;
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;
            array = Arrays.copyOf(array, newSize);
            return;
        }
        if (size < (arrayCapacity / 2)) {
            int newCapacity = (arrayCapacity / 2);
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }

    @Override
    public E push(E item) {
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E item = (E) array[size - 1];
        array[size - 1] = null;
        size--;
        resize();
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    @Override
    public int search(Object value) {
        if (value == null) {
            for (int idx = size - 1; idx >= 0; idx--) {
                if (array[idx] == null) {
                    return size - idx;
                }
            }
        } else {
            for (int idx = size - 1; idx >= 0; idx--) {
                if (array[idx].equals(value)) {
                    return size - idx;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}