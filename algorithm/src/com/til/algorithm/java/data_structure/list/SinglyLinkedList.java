package com.til.algorithm.java.data_structure.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        if (size == 0) {
            addFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node<E> prev = search(index - 1);
        Node<E> next = prev.next;
        Node<E> newNode = new Node<>(value);
        prev.next = newNode;
        newNode.next = next;
        size++;
    }

    public E remove() {
        Node<E> headNode = head;
        if (headNode == null) {
            throw new NoSuchElementException();
        }
        E element = headNode.data;
        Node<E> next = headNode.next;
        head.data = null;
        head.next = null;
        head = next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {
        if (index == 0) {
            return remove();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> prev = search(index - 1);
        Node<E> target = prev.next;
        Node<E> next = target.next;
        E element = target.data;
        prev.next = next;
        if (prev.next == null) {
            tail = prev;
        }
        target.data = null;
        target.next = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prev = head;
        Node<E> curr = head;

        while (curr != null) {
            if (value.equals(curr.data)) {
                break;
            }
            prev = curr;
        }
        if (curr == null) {
            return false;
        }
        if (curr.equals(head)) {
            remove();
            return true;
        }
        prev.next = curr.next;
        if (prev.next == null) {
            tail = prev;
        }
        curr.data = null;
        curr.next = null;
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}