package com.til.algorithm.ds.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://coding-factory.tistory.com/552
 *
 *  중간에 데이터를 추가나 삭제하더라도 전체의 인덱스가 한 칸씩 뒤로 밀리거나 당겨지는 일이 없기에 ArrayList에 비해서 데이터의 추가나 삭제가 용이하나
 *  인덱스가 없기에 특정 요소에 접근하기 위해서는 순차 탐색이 필요로 하여 탐색 속도가 떨어진다는 단점이 있다.
 *  따라서 데이터의 추가 및 삭제가 많은 경우 연결 리스트를 사용하는 것이 좋다.
 *
 */
public class LinkedListTest {

    @Test
    @DisplayName("LinkedList 생성")
    void create() {
        LinkedList linkedList = new LinkedList();
        LinkedList<LinkedListTest> tests = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<Integer>();
        LinkedList<Integer> num2 = new LinkedList<>();
        LinkedList<Integer> num3 = new LinkedList<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("LinkedList 값 추가")
    void add() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1); // 가장 앞단에 값 추가
        list.addLast(2); // 가장 뒷단에 값 추가
        list.add(3);
        list.add(1, 100); // index 1 에 100 추가
    }

    @Test
    @DisplayName("LinkedList 값 삭제")
    void remove() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        assertEquals(list.removeFirst(), 1);
        assertEquals(list.removeLast(), 3);
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("LinkedList 값 조회")
    void get() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        assertEquals(list.getFirst(), 1);
        assertEquals(list.getLast(), 3);
    }

    @Test
    @DisplayName("LinkedList 값 출력")
    void print() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        for (Integer i : list) {
            System.out.println(i);
        }

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    @DisplayName("LinkedList 값 검색")
    void search() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        assertTrue(list.contains(1));
        assertEquals(list.indexOf(2), 1);
        assertEquals(list.indexOf(5), -1);
    }
}
