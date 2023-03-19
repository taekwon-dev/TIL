package com.til.algorithm.java.data_structure.queue;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E item) {
        Node<E> newNode = new Node<>(item);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        E item = head.data;
        Node<E> next = head.next;
        head.data = null;
        head.next = null;
        head = next;
        size--;
        return item;
    }

    public E remove() {
        E item = poll();
        if (Objects.isNull(item)) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return head.data;
    }

    public E element() {
        E item = peek();
        if (Objects.isNull(item)) {
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
        Node curr = head;
        while (curr != null) {
            if (item.equals(curr.data)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void clear() {
        Node curr = head;
        while (curr != null) {
            Node<E> next = curr.next;
            curr.data = null;
            curr.next = null;
            curr = next;
        }
        size = 0;
        head = tail = null;
    }
}