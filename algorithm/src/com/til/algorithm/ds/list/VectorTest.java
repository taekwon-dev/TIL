package com.til.algorithm.ds.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  https://coding-factory.tistory.com/553
 *
 *  Vector 는 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드를 실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드들이 실행할 수 있습니다. (동기화 처리)
 */
public class VectorTest {

    @Test
    @DisplayName("Vector 선언")
    void create() {
        Vector v = new Vector();
        Vector<Integer> v2 = new Vector<Integer>();
        Vector<Integer> v3 = new Vector<>();
        Vector<Integer> v4 = new Vector<>(10);
        Vector<Integer> v5 = new Vector<>(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("Vector 값 추가")
    void add() {
        Vector<Integer> v = new Vector<>();
        v.add(1); // index 0
        v.add(2); // index 1
        v.add(3); // index 2

        v.add(1, 10); // 1번 index 에 10을 넣는다. (이 때 기존 1번 index 의 값 부터 한 칸씩 뒤로 밀린다)
        assertTrue(v.get(1) == 10);
        assertTrue(v.get(2) == 2);

        v.add(null); // null 값도 넣을 수 있다.
    }

    @Test
    @DisplayName("Vector 값 삭제")
    void remove() {
        Vector<Integer> v = new Vector<>(Arrays.asList(1, 2, 3));
        v.remove(0);
        assertTrue(v.size() == 2);
        v.clear();
        assertTrue(v.size() == 0);
        v.add(1);
        v.add(2);
        v.removeAllElements();
        assertTrue(v.size() == 0);
    }

    @Test
    @DisplayName("Vector 값 출력")
    void print() {
        Vector<Integer> v = new Vector<>(Arrays.asList(1, 2, 3));
        System.out.println("v.get(0) = " + v.get(0));

        // for - loop
        for (int num : v) {
            System.out.println(num);
        }

        // iterator
        Iterator iter = v.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
