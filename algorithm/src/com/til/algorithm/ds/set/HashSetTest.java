package com.til.algorithm.ds.set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://coding-factory.tistory.com/554
 *
 *  1. 객체를 중복해서 저장할 수 없다.
 *  2. 하나의 null 만 저장할 수 있다.
 *  3. 저장 순서가 보장되지 않는다.
 *
 *  특징 :
 *  인덱스가 존재하지 않아 값을 추가하거나 삭제할 때는 추가 또는 삭제하고자 하는 값이 Set 내부에 있는지 확인한 뒤 추가 또는 삭제를 해야 하므로 List 구조에 비해 느리다.
 *
 *  중복 제거 과정 :
 *  객체 저장 전, hashCode() 를 통해 해시 코드를 얻은 뒤 저장되어 객체와 해시 코드를 비교 한 뒤 같은 해시 코드가 있다면 equals() 에 대해 true 를 반환하는 경우 동일한 객체로 판단하여 저장하지 않는다.
 */
class HashSetTest {

    @Test
    @DisplayName("HashSet 선언")
    void createHashSet() {

        /**
         *  초기 생성 시 initial capacity : 16, load factor : 0.75 로 설정
         *  초기 저장 공간 보다 더 큰 공간이 필요한 경우 두배로 저장 공간을 늘리는데 이 과정에서 과부하가 있으므로 저장 공간을 미리 알고 있다면 초기 값을 설정하는 것이 좋다.
         */
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>(set1);
        HashSet<Integer> set4 = new HashSet<>(10);
        HashSet<Integer> set5 = new HashSet<>(10, 0.5f);
        HashSet<Integer> set6 = new HashSet<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("HashSet 값 추가")
    void add() {

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        assertTrue(set.size() == 3);

        set.add(3);
        assertTrue(set.size() == 3);
    }

    @Test
    @DisplayName("HashSet 값 삭제")
    void remove() {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));

        set.remove(1);
        assertTrue(set.size() == 2);
        assertTrue(set.remove(2)); // 삭제 하려는 값이 Set 에 있는 경우 true 반환 (없는 경우 false 반환)

        set.clear();
        assertTrue(set.size() == 0);
    }

    @Test
    @DisplayName("HashSet 값 출력")
    void print() {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("set = " + set); // [1, 2, 3, 4, 5]

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    @DisplayName("HashSet 값 검색")
    void search() {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        assertTrue(set.contains(5));
        assertFalse(set.contains(99));
    }
}