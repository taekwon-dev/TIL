package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  https://www.programcreek.com/2014/04/leetcode-combination-sum-ii-java/ 코드 분석
 *  each time start from different element
 *
 *  1, 1, 2, 3  k = 4
 *
 *  1(1) + 1(2) + 2
 *  1(2) + 3
 *
 *  1, 1, 1, 2, 3  k = 5
 *
 *  1(1) + 1(2) + 1(3) + 2
 *  1(2) + 1(3) + 3
 *  2 + 3
 *
 *  정렬 후 (같은 수를 인접하도록 한 뒤) 시작 위치를 매번 다르게 설정 (한 칸 다음)
 */
public class LEET_40 {

    public static void main(String[] args) {
        List<List<Integer>> answer = combinationSum2(new int[]{1, 1, 2, 3}, 4);
        System.out.println("answer = " + answer);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, curr, 0, target, candidates);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
        if(target==0){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if(target<0){
            return;
        }

        int prev=-1;
        for(int i=start; i<candidates.length; i++){
            if(prev!=candidates[i]){ // each time start from different element
                curr.add(candidates[i]);
                prev=candidates[i];
                helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
                curr.remove(curr.size()-1);
            }
        }
    }
}
