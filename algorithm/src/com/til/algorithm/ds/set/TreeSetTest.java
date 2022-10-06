package com.til.algorithm.ds.set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeSetTest {

    @Test
    @DisplayName("TreeSet 선언")
    void createTreeSet() {

        TreeSet<Integer> set1 = new TreeSet<Integer>();
        TreeSet<Integer> set2 = new TreeSet<>();
        TreeSet<Integer> set3 = new TreeSet<>(set1);
        TreeSet<Integer> set4 = new TreeSet<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("TreeSet 값 추가")
    void add() {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.size() == 3);

        set.add(3);
        assertTrue(set.size() == 3);
    }

    @Test
    @DisplayName("TreeSet 값 삭제")
    void remove() {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3));

        set.remove(1);
        assertTrue(set.size() == 2);
        assertTrue(set.remove(2)); // 삭제 하려는 값이 Set 에 있는 경우 true 반환 (없는 경우 false 반환)

        set.clear();
        assertTrue(set.size() == 0);
    }

    @Test
    @DisplayName("TreeSet 값 출력")
    void print() {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("set = " + set); // [1, 2, 3, 4, 5]
        System.out.println("set.first() = " + set.first()); // 1
        System.out.println("set.last() = " + set.last()); // 5
        System.out.println("set.higher(1) = " + set.higher(1)); // 입력 값 보다 큰 데이터 중 최소값 (1, 2, 3, 4, 5 중 1을 인자로 넘기면 2를 반환)
        System.out.println("set.lower(2) = " + set.lower(2));   // 입력 값 보다 작은 데이터 중 최대값 (1, 2, 3, 4, 5 중 2를 인자로 넘기면 1을 반환)

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    @DisplayName("TreeSet 값 검색")
    void search() {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));

        assertTrue(set.contains(5));
        assertFalse(set.contains(99));
    }
}