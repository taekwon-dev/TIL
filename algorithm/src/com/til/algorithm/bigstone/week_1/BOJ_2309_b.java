package com.til.algorithm.bigstone.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2309_b {

    private static int[] arr = new int[9];
    private static List<List<Integer>> combinations = new ArrayList<>();
    private static List<Integer> combination = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        backtracking(0, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combinations.get(0).size(); i++) {
            sb.append(combinations.get(0).get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
        for (int i = index; i < 9; i++) {
            combination.add(arr[i]);
            backtracking(depth + 1, i + 1, sum + arr[i]);
            combination.remove(combination.size() - 1);
        }
    }
}