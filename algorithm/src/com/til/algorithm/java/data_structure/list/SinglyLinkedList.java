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

    /**
     *  1) 노드 생성
     *  2) 생성한 노드의 다음 노드를 헤드로 지정
     *  3) 헤드 재지정
     *  4) 사이즈 업
     *  5) (재지정된 헤드의 다음 노드가 Null 인 경우 테일노드로 지정)
     */
    public void addFirst(E value) {
        SNode<E> newNode = new SNode<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    /**
     *  List 인터페이스에서 정의한 add(E value)는 맨 뒤에 추가하는 것을 의미
     */
    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    /**
     *  사이즈가 0인 경우 선두에 새로운 노드를 추가하는 것과 동일
     *
     *  1) 새로운 노드 생성
     *  2) 테일의 다음 노드를 생성한 노드로 지정
     *  3) 테일 재지정
     *  4) 사이즈 업
     */
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

    /**
     *  - 주어진 인덱스가 유효한 범위에 있는지 체크
     *  - 주어진 인데스가 0인 경우 ... addFirst(E value)
     *  - 주어진 인덱스가 size인 경우 ... addLast(E value)
     *
     *  1) 주어진 인덱스 이전 노드를 가리키는 변수 생성 (prev)
     *  2) 새로운 노드의 다음 노드로 가리키는 변수 생성 (next)
     *  3) 노드 생성
     *  4) prev 다음 노드를 생성한 노드로 지정
     *  5) 새로 생성한 노드의 다음 노드를 next 노드로 지정
     *  6) 사이즈 업
     */
    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
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

    /**
     *  헤드 노드 삭제
     */
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

    /**
     *  주어진 인덱스에 위치한 노드 삭제
     */
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

    /**
     *  특정 값을 갖는 노드 삭제 (해당 값을 갖는 첫 번째 노드)
     */
    @Override
    public boolean remove(Object value) {
        SNode<E> prev = head;
        SNode<E> curr = head;
        boolean hasValue = false;

        for (; curr != null; curr = curr.next) {
            if (value.equals(curr.data)) {
                hasValue = true;
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