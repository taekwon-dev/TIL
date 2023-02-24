package com.til.algorithm.java.data_structure;

public interface List<E> {

    boolean add(E value);

    void add(int index, E value);

    E remove(int index);

    boolean remove(Object value);

    E get(int index);

    void set(int index, E value);

    boolean contains(Object value);

    int indexOf(Object value);

    int size();

    boolean isEmpty();

    void clear();
}
