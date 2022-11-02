package com.til.algorithm.ds.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://coding-factory.tistory.com/557
 */
class TreeMapTest {

    @Test
    @DisplayName("TreeMap 선언")
    void createTreeMap() {
        TreeMap<Integer, String> map1 = new TreeMap<Integer, String>();
        TreeMap<Integer, String> map2 = new TreeMap<>();
        TreeMap<Integer, String> map3 = new TreeMap<>(map1);
        TreeMap<Integer, String> map4 = new TreeMap<>(){{
            put(1, "TreeMap");
        }};
    }

    @Test
    @DisplayName("TreeMap 값 추가")
    void add() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        assertTrue(map.size() == 3);

        map.put(3, "3등 (중복)");
        assertTrue(map.size() == 3);
        assertTrue(map.get(3).equals("3등 (중복)"));
    }

    @Test
    @DisplayName("TreeMap 값 삭제")
    void remove() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        map.remove(3);
        assertTrue(map.size() == 2);

        map.clear();
        assertTrue(map.size() == 0);
    }

    @Test
    @DisplayName("TreeMap 단일 값 출력")
    void print() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        /**
         *  map = {1=1등, 2=2등, 3=3등}
         *  map.get(1) = 1등
         *  map.firstEntry() = 1=1등
         *  map.firstKey() = 1
         *  map.lastEntry() = 3=3등
         *  map.lastKey() = 3
         */
        System.out.println("map = " + map);
        System.out.println("map.get(1) = " + map.get(1));
        System.out.println("map.firstEntry() = " + map.firstEntry());
        System.out.println("map.firstKey() = " + map.firstKey());
        System.out.println("map.lastEntry() = " + map.lastEntry());
        System.out.println("map.lastKey() = " + map.lastKey());
    }

    @Test
    @DisplayName("HashMap 값 출력 via KeySet()")
    void printWithKeySet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        /**
         * [Key]:1 [Value]:1등
         * [Key]:2 [Value]:2등
         * [Key]:3 [Value]:3등
         */
        for (Integer i : map.keySet()) {
            System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
        }
    }

    @Test
    @DisplayName("TreeMap 값 출력 via EntrySet()")
    void printWithEntrySet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        /**
         * [Key]:1 [Value]:1등
         * [Key]:2 [Value]:2등
         * [Key]:3 [Value]:3등
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }
    }

    @Test
    @DisplayName("HashMap 값 출력 via Iterator() + KeySet()")
    void printWithIteratorKeySet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
        }
    }

    @Test
    @DisplayName("HashMap 값 출력 via Iterator() + EntrySet()")
    void printWithIteratorEntrySet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        Iterator<Map.Entry<Integer, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }
    }

}