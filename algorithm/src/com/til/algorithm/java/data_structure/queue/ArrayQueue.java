package com.til.algorithm.java.data_structure.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue {

    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity) {
        int arrayCapacity = array.length;
        Object[] newArray = new Object[newCapacity];
        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;
        front = 0;
        rear = size;
    }

    /**
     *  큐를 배열 기반으로 구현할 때, 데이터 삽입 / 삭제 과정에서 점차 뒤쪽으로 데이터가 쌓이는 구조를 갖게된다.
     *  이러한 양상을 막기 위해 데이터 삽입 시, 앞 쪽의 빈 공간이 있으면 해당 공간에 데이터를 추가하는 식으로 처리하고
     *  빈 공간이 없으면 동적으로 사이즈를 재할당하는 방식으로 처리한다.
     */
    @Override
    public boolean offer(Object item) {
        if ((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length;
        array[rear] = item;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        front = (front + 1) % array.length;
        E item = (E) array[front];
        array[front] = null;
        size--;
        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return item;
    }

    public E remove() {
        E item = poll();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        E item = (E) array[(front + 1) % array.length];
        return item;
    }

    public E element() {
        E item = peek();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object item) {
        int start = (front + 1) % array.length;
        for (int i = 0, index = start; i < size; i++, index = (index + 1) % array.length) {
            if (array[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        front = rear = size = 0;
    }
}