package problem_solving.baekjoon.big_stone.week6.기타_레슨_2343;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ps_2025_01_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lectures = new int[N];
        int totalSum = 0, maxLecture = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            totalSum += lectures[i];
            maxLecture = Math.max(maxLecture, lectures[i]);
        }

        int low = maxLecture;
        int high = totalSum;
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDivide(lectures, M, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivide(int[] lectures, int M, int size) {
        int count = 1;
        int sum = 0;

        for (int lecture : lectures) {
            if (sum + lecture > size) {
                count++;
                sum = lecture;
                if (count > M) return false;
            } else {
                sum += lecture;
            }
        }

        return true;
    }
}