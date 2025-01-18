package problem_solving.leetcode.problems.assign_cookies;

import java.util.Arrays;

public class ps_2025_01_18_v2 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int answer = 0;
        int gIdx = 0;
        int sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx]) {
                answer++;
                gIdx++;
            }
            sIdx++;
        }

        return answer;
    }
}
