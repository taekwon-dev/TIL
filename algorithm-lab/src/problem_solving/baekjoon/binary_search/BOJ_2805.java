package problem_solving.baekjoon.binary_search;

import java.util.*;
import java.io.*;

// Mid 포인트를 우측 기준으로 잡기.
public class BOJ_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] treeLengths = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeLengths[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(treeLengths);

        System.out.println(binarySearch(treeLengths, m));
    }

    private static long binarySearch(long[] treeLengths, int m) {
        long left = 0;
        long right = treeLengths[treeLengths.length - 1] - 1;

        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            long outcome = 0;
            for (long treeLength : treeLengths) {
                if (treeLength > mid) {
                    outcome += treeLength - mid;
                }
            }

            if (outcome >= (long) m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
