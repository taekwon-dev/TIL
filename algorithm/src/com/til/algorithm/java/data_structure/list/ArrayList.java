package com.til.algorithm.java.data_structure.list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size;
    Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        int array_capacity = array.length;

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }
        if (size == array_capacity) {
            int new_capacity = array_capacity * 2;
            array = Arrays.copyOf(array, new_capacity);
            return;
        }
        if (size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;
            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(value);
        } else {
            if (size == array.length) {
                resize();
            }
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        }
    }

    public void addFirst(E value) {
        add(0, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void set(int index, E value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public int indexOf(Object value) {
        for (int idx = 0; idx < size; idx++) {
            if (array[idx].equals(value)) {
                return idx;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int idx = size - 1; idx >= 0; idx--) {
            if (array[idx].equals(value)) {
                return idx;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        if (indexOf(value) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E value = (E) array[index];
        array[index] = null;
        for (int idx = index; idx < size - 1; idx++) {
            array[idx] = array[idx + 1];
            array[idx + 1] = null;
        }
        size--;
        resize();
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int idx = 0; idx < size; idx++) {
            array[idx] = null;
        }
        size = 0;
        resize();
    }
}