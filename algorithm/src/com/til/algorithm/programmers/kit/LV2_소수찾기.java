package com.til.algorithm.programmers.kit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LV2_소수찾기 {

    private Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        char[] number = numbers.toCharArray();
        Arrays.sort(number);
        backtracking(number, new boolean[number.length], 0, "");
        return set.size();
    }

    private void backtracking(char[] number, boolean[] visited, int depth, String s) {
        if (s.length() >= 1 && isPrime(Integer.parseInt(s))) {
            set.add(Integer.parseInt(s));
        }

        int prev = -1;
        for (int i = 0; i < number.length; i++) {
            if (!visited[i] && prev != number[i]) {
                prev = number[i];
                visited[i] = true;
                backtracking(number, visited, depth + 1, s + number[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
