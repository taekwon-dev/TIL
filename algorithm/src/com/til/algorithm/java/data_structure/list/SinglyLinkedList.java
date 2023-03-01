package com.til.algorithm.java.data_structure.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private SNode<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        SNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void addFirst(E value) {
        SNode<E> newNode = new SNode<>(value);
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
        SNode<E> newNode = new SNode<>(value);
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
        SNode<E> prev = search(index - 1);
        SNode<E> next = prev.next;
        SNode<E> newNode = new SNode<>(value);
        prev.next = newNode;
        newNode.next = next;
        size++;
    }

    public E remove() {
        SNode<E> headNode = head;
        if (headNode == null) {
            throw new NoSuchElementException();
        }
        E element = headNode.data;
        SNode<E> next = headNode.next;
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
        SNode<E> prev = search(index - 1);
        SNode<E> target = prev.next;
        SNode<E> next = target.next;
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
        SNode<E> prev = head;
        SNode<E> curr = head;

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
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        SNode<E> replaceNode = search(index);
        replaceNode.data = value;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        SNode<E> curr = head;
        while (curr != null) {
            if (value.equals(curr.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
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
        for (SNode<E> curr = head; curr != null;) {
            SNode<E> next = curr.next;
            curr.data = null;
            curr.next = null;
            curr = next;
        }
        head = tail = null;
        size = 0;
    }
}