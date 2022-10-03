package com.til.algorithm.ds.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  https://coding-factory.tistory.com/556
 */
class HashMapTest {

    @Test
    @DisplayName("HashMap 선언")
    void createHashMap() {
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<>();
        HashMap<String, String> map3 = new HashMap<>(map1);
        HashMap<String, String> map4 = new HashMap<>(10);
        HashMap<String, String> map5 = new HashMap<>(10, 0.5f);
        HashMap<String, String> map6 = new HashMap<>(){{
            put("Map", "HashMap");
        }};
    }

    @Test
    @DisplayName("HashMap 값 추가")
    void add() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        assertTrue(map.size() == 3);

        map.put(3, "3등 (중복)");
        assertTrue(map.size() == 3);
        assertTrue(map.get(3).equals("3등 (중복)"));
    }

    @Test
    @DisplayName("HashMap 값 삭제")
    void remove() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        map.remove(3);
        assertTrue(map.size() == 2);

        map.clear();
        assertTrue(map.size() == 0);
    }

    @Test
    @DisplayName("HashMap 값 출력")
    void print() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1등");
        map.put(2, "2등");
        map.put(3, "3등");

        System.out.println("map = " + map); // {1=1등, 2=2등, 3=3등}
        System.out.println("map.get(1) = " + map.get(1)); // 1등
    }

    @Test
    @DisplayName("HashMap 값 출력 via KeySet()")
    void printWithKeySet() {
        HashMap<Integer, String> map = new HashMap<>();
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
    @DisplayName("HashMap 값 출력 via EntrySet()")
    void printWithEntrySet() {
        HashMap<Integer, String> map = new HashMap<>();
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
        HashMap<Integer, String> map = new HashMap<>();
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
        HashMap<Integer, String> map = new HashMap<>();
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