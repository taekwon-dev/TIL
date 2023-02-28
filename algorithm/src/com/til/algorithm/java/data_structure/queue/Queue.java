package com.til.algorithm.java.data_structure.queue;

public interface Queue<E> {

    boolean offer(E item);

    E poll();

    E peek();
}
