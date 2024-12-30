package problem_solving.leetcode.blind_75.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class ps_2024_12_29 {

    private List<Integer> candidate = new ArrayList<>();
    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);

        return answer;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIdx) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(candidate));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            candidate.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            candidate.remove(candidate.size() - 1);
        }
    }
}
