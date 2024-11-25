package problem_solving.baekjoon.two_pointer;

import java.util.*;
        import java.io.*;

// sum = 0
import java.util.*;
import java.io.*;

public class BOJ_1806_V2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int p2 = 0;
        for (int p1 = 0; p1 < n; p1++) {
            while (p2 < n && sum < s) {
                sum += arr[p2];
                p2++;
            }
            if (p2 <= n && sum >= s) {
                minLen = Math.min(minLen, p2 - p1);
            }

            sum -= arr[p1];
        }

        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        System.out.println(minLen);
    }
}