package com.til.algorithm.leetCode.backtracking;

import java.util.HashSet;

public class LEET_1079 {
    public static int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }
        HashSet<String> hashSet = new HashSet<>();
        char[] arr = tiles.toCharArray();
        boolean[] visited = new boolean[tiles.length()];
        backtracking(arr, visited, "", hashSet);
        return hashSet.size();
    }

    private static void backtracking(char[] arr, boolean[] visited, String item, HashSet<String> hashSet) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                hashSet.add(item + arr[i]);
                backtracking(arr, visited, item + arr[i], hashSet);
                visited[i] = false;
            }
        }
    }
}
