package com.til.algorithm.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *  https://st-lab.tistory.com/243
 *  " 우리가 원하는 것은 Comparator 비교 기능만 따로 두고 싶은 것이다. "
 *    Comparator 기능만 따로 두고 싶다면 어떻게 해야할까?
 *    익명 객체(클래스)를 활용한다
 */
class ComparatorTest {

    @Test
    @DisplayName("Integer 오름차순 + 익명 객체 활용(인터페이스 구현)")
    void ascendingInteger() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 7, 5, 9));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        list.equals(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9)));
    }

    @Test
    @DisplayName("Integer 내림차순 + 람다식 활용")
    void descendingInteger() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 7, 5, 9));
        Collections.sort(list, (o1, o2) -> o2 - o1);
        list.equals(new ArrayList<>(Arrays.asList(9, 7, 5, 3, 1)));
    }
}
