package problem_solving.baekjoon.big_stone.week6.보석_상자_2792;

import java.util.*;
import java.io.*;

public class ps_2025_01_15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] jewels = new int[m];

        int low = 1;
        int high = 0;
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            if (high < jewels[i]) {
                high = jewels[i];
            }
        }

        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int studentNum = 0;

            for (int jewel : jewels) {
                studentNum += jewel / mid;

                if (jewel % mid != 0) {
                    studentNum++;
                }
            }

            if (studentNum <= n) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
