package problem_solving.leetcode.problems.assign_cookies;

import java.util.PriorityQueue;

public class ps_2025_01_18_v1 {

    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> gMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> sMinHeap = new PriorityQueue<>();

        for (int i = 0; i < g.length; i++) {
            gMinHeap.offer(g[i]);
        }
        for (int i = 0; i < s.length; i++) {
            sMinHeap.offer(s[i]);
        }

        int answer = 0;
        while (!gMinHeap.isEmpty() && !sMinHeap.isEmpty()) {
            if (gMinHeap.peek() <= sMinHeap.peek()) {
                gMinHeap.poll();
                sMinHeap.poll();
                answer++;
            } else {
                sMinHeap.poll();
            }
        }

        return answer;
    }
}
