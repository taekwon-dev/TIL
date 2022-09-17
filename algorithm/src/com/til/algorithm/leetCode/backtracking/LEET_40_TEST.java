package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  배열 내 중복되는 수가 없는 경우
 *  주어진 배열이 오름차순으로 정렬되어 있다면 인덱스 지정 필요 없음
 *  +
 *  단, 배열 내 중복된 수가 있는 경우 결과 리스트가 중복되는 경우 발생
 */
public class LEET_40_TEST {
    static int target = 3;
    static int[] nums = {1, 2, 3};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        backtracking(0, "");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private static void backtracking(int sum, String str) {
        if (sum > target) return;
        if (sum == target) {
            list.add(str);
        }
        for (int i = 0; i < nums.length; i++) {
            backtracking(sum + nums[i], str + nums[i]);
        }
    }
}
