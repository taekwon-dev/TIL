package com.til.algorithm.java.data_structure.heap;

import java.util.Comparator;

public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
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

    public void add(E value) {
        if (size + 1 == array.length) {
            resize(array.length * 2);
        }
        /**
         *  Heap 의 데이터 추가 시 가장 뒤에 추가한다.
         */
        shiftUp(size + 1, value);
        size++;
    }

    private void shiftUp(int index, E target) {
        if (comparator != null) {
            shiftUpComparator(index, target, comparator);
        } else {
            shiftUpComparable(index, target);
        }
    }

    private void shiftUpComparator(int index, E target, Comparator<? super E> comparator) {
        while (index > 1) {
            int parent = getParent(index);
            Object parentVal = array[parent];

            /**
             *  Params:
             *   o1 – the first object to be compared.
             *   o2 – the second object to be compared.
             * Returns:
             *   a negative integer (the first argument is less than)
             *   zero (equal to)
             *   a positive integer (greater than the second)
             *
             *   Min Heap 을 구성하므로, 새로 추가한 노드(=자식 노드)가 더 크면
             *   부모 자식 노드 값을 교환하지 않아도 된다.
             */
            if (comparator.compare(target, (E) parentVal) >= 0) {
                break;
            }
            /**
             *  부모 노드 값보다 새로 추가한 노드(=자식 노드)가 더 큰 경우
             *  부모 노드와 자식 노드의 값을 교환한다.
             *  그리고, 부모 노드를 기준으로 다시 부모 노드의 부모 노드와 동일한 작업을 한다
             */
            array[index] = parentVal;
            index = parent;
        }
        array[index] = target;
    }

    private void shiftUpComparable(int index, E target) {
        Comparable<? super E> comparable = (Comparable<? super E>) target;

        while (index > 1) {
            int parent = getParent(index);
            Object parentVal = array[parent];

            /**
             *  Params:
             *    o – the object to be compared.
             * Returns:
             *   a negative integer (this object is less than)
             *   zero (equal to)
             *   or a positive integer (greater than the specified object)
             */
            if (comparable.compareTo((E) parentVal) >= 0) {
                break;
            }
            array[index] = parentVal;
            index = parent;
        }
        array[index] = comparable;
     }

    public E remove() {
        return null;
    }

    private void shiftDown(int index, E target) {

    }

    private void shiftDownComparator(int index, E target, Comparator<? super E> comparator) {
        array[index] = null;
        size--;

        int parent = index;
        int child;

        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(parent);
            Object childVal = array[child];

            if (right <= size && comparator.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if (comparator.compare(target, (E) childVal) <= 0) {
                break;
            }
            array[parent] = target;
            if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
                resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
            }
        }
    }

    private void shiftDownComparable(int index, E target) {

    }
}