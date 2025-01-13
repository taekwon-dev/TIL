package problem_solving.leetcode.blind_75.combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ps_2025_01_13 {

    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);

        return combinations;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIdx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
