package com.til.algorithm.leetCode.string;

import java.util.LinkedList;

/**
 *  Linked List 자료구조 활용 (두 개의 포인터를 활용해서 마지막 결과물에 대해 역순 처리를 생략할 수 있음)
 */
public class LEET_1047_a {

    public String removeDuplicates(String s) {
        LinkedList<Character> list = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (!list.isEmpty() && list.getLast() == c) {
                list.removeLast();
            } else {
                list.addLast(c);
            }
        }
        if (list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (list.size() != 0) {
            sb.append(list.removeFirst());
        }
        return sb.toString();
    }
}