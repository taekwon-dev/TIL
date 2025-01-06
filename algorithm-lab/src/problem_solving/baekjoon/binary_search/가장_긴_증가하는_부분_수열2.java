package problem_solving.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열 A의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findLISLength(a));
    }

    public static int findLISLength(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int pos = lowerBound(lis, num);

            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }

    private static int lowerBound(List<Integer> lis, int key) {
        int low = 0;
        int high = lis.size(); // 리스트 사이즈 범위 밖으로 커질 수 있음!

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (lis.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
