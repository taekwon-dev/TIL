package com.til.algorithm.ds.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedHashMapTest {

    @Test
    @DisplayName("LinkedHashMap 생성")
    void create() {
        LinkedHashMap map = new LinkedHashMap();
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> map3 = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> map4 = new LinkedHashMap<>(10);
        LinkedHashMap<String, Integer> map5 = new LinkedHashMap<>(10, 0.75f);
        LinkedHashMap<String, Integer> map6 = new LinkedHashMap<>() {{
            put("age", 94);
            put("has been", 5);
        }};
    }

    @Test
    @DisplayName("LinkedHashMap 값 추가")
    void add() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("10", 10);
        map.put("20", 20);
    }

    @Test
    @DisplayName("LinkedHashMap 값 제거")
    void remove() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>() {{
            put("10", 10);
            put("20", 20);
            put("30", 30);
            put("40", 40);
        }};

        map.remove("10");
        assertEquals(map.size(), 3);
        map.remove("20", 20);
        assertEquals(map.size(), 2);
    }
}