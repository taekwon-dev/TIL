package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] waters = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            waters[i][0] = Integer.parseInt(st.nextToken());
            waters[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(waters, (w1, w2) -> {
            if (w1[0] == w2[0]) {
                return w1[1] - w2[1];
            }
            return w1[0] - w2[0];
        });

        int answer = 0;
        int cover = 0;
        for (int i = 0; i < N; i++) {
            // 물 웅덩이 시작 위치가 커버에 걸치지 않는 경우, 해당 위치에 새로운 커버를 활용해 덮어야 하므로 커버의 시작 위치로 초기화
            if (waters[i][0] > cover) {
                cover = waters[i][0];
            }
            // 물 웅덩이 끝나는 위치가 커버보다 큰 경우, 커버를 추가
            if (waters[i][1] >= cover) {
                // 커버가 완전히 물 웅덩이를 덮을 때 까지
                while (waters[i][1] > cover) {
                    // 커버를 추가
                    cover += L;
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}