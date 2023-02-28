package com.til.algorithm.java.data_structure.stack;

import com.til.algorithm.java.data_structure.list.ArrayList;

import java.util.EmptyStackException;

public class StackExtendArrayList<E> extends ArrayList<E> implements StackInterface<E> {

    public StackExtendArrayList() {
        super();
    }

    public StackExtendArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public E push(E item) {
        addLast(item);
        return item;
    }

    @Override
    public E pop() {
        int length = size();
        E item = remove(length - 1);
        return item;
    }

    @Override
    public E peek() {
        int length = size();
        if (length == 0) {
            throw new EmptyStackException();
        }
        E item = get(length - 1);
        return item;
    }

    @Override
    public int search(Object value) {
        int index = lastIndexOf(value);
        if (index >= 0) {
            return size() - index;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
