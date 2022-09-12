package com.til.algorithm.data_structure.map;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        단일_값_출력();
        전체_값_출력();
        전체_값_출력_Iterator();
    }

    private static void 선언() {
        TreeMap<Integer, String> tm1 = new TreeMap<Integer, String>();
        TreeMap<Integer, String> tm2 = new TreeMap<>();
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);
        TreeMap<Integer, String> tm4 = new TreeMap<>() {{
            put(1, "a");
            put(2, "b");
        }};
    }

    private static void 값_추가() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "자바");
        map.put(2, "루비");
        map.put(3, "파이썬");
    }

    private static void 값_삭제() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "자바");
        map.put(2, "루비");
        map.put(3, "파이썬");

        map.remove(1);
        map.clear();
    }

    private static void 단일_값_출력() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "자바");
        map.put(2, "루비");
        map.put(3, "파이썬");

        System.out.println("map = " + map);
        System.out.println("map.get(1) = " + map.get(1));
        System.out.println("map.firstKey() = " + map.firstKey());
        System.out.println("map.firstEntry() = " + map.firstEntry());
        System.out.println("map.lastKey() = " + map.lastKey());
        System.out.println("map.lastEntry() = " + map.lastEntry());
    }

    private static void 전체_값_출력() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "자바");
        map.put(2, "루비");
        map.put(3, "파이썬");

        // EntrySet
        for (Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }

        // KeySet
        for (Integer i : map.keySet()) {
            System.out.println("key = " + i + " value = " + map.get(i));
        }
    }

    private static void 전체_값_출력_Iterator() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "자바");
        map.put(2, "루비");
        map.put(3, "파이썬");

        // EntrySet
        Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<Integer, String> entry = entries.next();
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }

        // KeySet
        Iterator<Integer> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println("key = " + key + " value = " + map.get(key));
        }
    }
}
