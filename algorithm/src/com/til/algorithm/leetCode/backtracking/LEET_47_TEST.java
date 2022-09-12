package com.til.algorithm.leetCode.backtracking;

public class LEET_47_TEST {
    static int[] nums = {1, 1, 2};
    static int[] arr = new int[3];
    static boolean[] visited = new boolean[3];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        backtracking(0);
//        backtrakcing2(0);
        backtracking3(0)
        ;
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void backtrakcing2(int depth) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = 0; i < 3; i++) {
            if (!visited[i] && prev != nums[i]) {
                visited[i] = true;
                prev = nums[i];
                arr[depth] = nums[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void backtracking3(int depth) {
        if (depth == 3) {
            for (int i = 0; i < 3; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = nums[i];
            backtracking3(depth + 1);
            visited[i] = false;
        }
    }
}
