package com.til.algorithm.ds.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    @DisplayName("ArrayList 생성")
    void create() {
        ArrayList list = new ArrayList();
        ArrayList<ArrayListTest> tests = new ArrayList<ArrayListTest>();
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<Integer> num2 = new ArrayList<>();
        ArrayList<Integer> num3 = new ArrayList<Integer>(10);
        ArrayList<Integer> num4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("ArrayList 값 추가")
    void add() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null); // null 추가 가능

        assertTrue(list.get(1) == 2);

        /**
         *  값 추가 시 index 중간에 값을 추가하면 해당 인덱스부터 마지막 인덱스까지 모두 1 씩 뒤로 밀려납니다.
         *  이 경우 데이터가 늘어나면 늘어날 수록 성능에 악영향이 있으므로, 중간에 데이터를 삽입해야 하는 경우가 잦다면
         *  ArrayList 보다는 LinkedList 를 활용하는 것이 좋을 수 있다.
         */
        list.add(1, 100); // index 위치에 값 100 추가
        assertTrue(list.get(1) == 100);
    }

    @Test
    @DisplayName("ArrayList 값 삭제")
    void remove() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.remove(1);
        list.remove(2);
        assertTrue(list.size() == 3);
        list.clear();
        assertTrue(list.size() == 0);
    }

    @Test
    @DisplayName("ArrayList 값 출력")
    void print() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i : list) {
            System.out.println(i);
        }
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Test
    @DisplayName("ArrayList 값 검색")
    void search() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertTrue(list.contains(1));
        assertTrue(list.indexOf(-1) == -1); // 해당 인덱스에 해당하는 값이 없는 경우 -1 리턴
        assertEquals(list.indexOf(1), 0); // 특정 값을 기준으로 인덱스 값 구하기
    }
}
