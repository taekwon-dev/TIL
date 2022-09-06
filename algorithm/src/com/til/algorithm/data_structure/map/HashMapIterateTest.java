package com.til.algorithm.data_structure.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Y", "TK");
        map.put("B", "SH");
        map.put("L", "JS");

        iterateWithKeySet();

        iterateWithEntrySet();

        iterateWithValues();

        iterateWIthForEach();
    }

    private static void iterateWithKeySet() {
        System.out.println("\n" + "Via KeySet");
        for (String key : map.keySet()) {
            String firstName = map.get(key);
            System.out.println("firstName = " + firstName);
        }
    }

    private static void iterateWithEntrySet() {
        System.out.println("\n" + "Via EntrySet");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lastName = entry.getKey();
            String firstName = entry.getValue();
            System.out.print("lastName = " + lastName + " ");
            System.out.println("firstName = " + firstName);
        }
    }

    private static void iterateWithValues() {
        System.out.println("\n" + "Via Values");
        List<String> firstNames = new ArrayList<>(map.values());
        for (String firstName : firstNames) {
            System.out.println("firstName = " + firstName);
        }
    }

    private static void iterateWIthForEach() {
        System.out.println("\n" + "Via ForEach");
        map.forEach((last, first) -> {
            System.out.print("last = " + last + " ");
            System.out.println("first = " + first);
        });
    }
}
