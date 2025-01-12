package problem_solving.leetcode.blind_75.combination_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * i = 0 → combination = [2]
 * i = 0 → combination = [2, 2]
 * i = 0 → combination = [2, 2, 2]
 * i = 0 → combination = [2, 2, 2, 2] (탐색 종료)
 * i = 1 → combination = [2, 2, 3] (저장)
 * i = 2 → combination = [2, 2, 6] (탐색 종료)
 * i = 3 → combination = [2, 2, 7] (탐색 종료)
 * i = 1 → combination = [2, 3]
 * i = 1 → combination = [2, 3, 3] (탐색 종료)
 * i = 2 → combination = [2, 3, 6] (탐색 종료)
 * i = 3 → combination = [2, 3, 7] (탐색 종료)
 * i = 2 → combination = [2, 6] (탐색 종료)
 * i = 3 → combination = [2, 7] (탐색 종료)
 * i = 1 → combination = [3]
 * i = 1 → combination = [3, 3]
 * i = 1 → combination = [3, 3, 3] (탐색 종료)
 * i = 3 → combination = [7] (저장)
 */
public class ps_2025_01_08 {

    List<List<Integer>> combinations;
    List<Integer> combination;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        combination = new ArrayList<>();

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
