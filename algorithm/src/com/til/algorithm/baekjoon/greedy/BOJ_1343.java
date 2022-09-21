package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 폴리오미노
 * <p>
 * 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. `AAAA`와 `BB`
 * 이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다. (-> X 가 있는 곳에만 둘 수 있는 조건)
 * <p>
 * 폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.
 * <p>
 * 첫째 줄에 사전순(-> AAAA 먼저 찍기)으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.
 * <p>
 * 4원 / 2원 짜리가 있고,
 * N 원을 거스름 돈을 줄 수 있는 경우
 * <p>
 * XXX -> 4원, 2원으로는 표현할 수 없음
 * <p>
 * XXXX XXXX XXXX -> AAAA AAAA AAAA
 * <p>
 * 한 자리씩 포인터를 두고 네 자리 문자열 (XXXX)가 있는 지 찾고, AAAA 배치하기
 * <p>
 * 그리고 두 가질 문자열 (XX)가 있으면 순차적으로 BB 배치하기
 * <p>
 * String.replace()
 */
public class BOJ_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // (1)
        str = str.replaceAll("XXXX", "AAAA");
        str = str.replaceAll("XX", "BB");

        if (str.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(str);
        }

        // (2)
        char[] board = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            if (i + 3 < board.length) {
                // AAAA 가 되는 지 확인
                boolean X4 = board[i] == board[i + 1] && board[i] == board[i + 2] && board[i] == board[i + 3];

                if (X4 && board[i] == 'X') {
                    i += 3;
                    sb.append("AAAA");
                    // 포인터를 하나씩 이동 또는 네 개의 XXXX가 있어서 AAAA로 대체한 뒤에는 포인터를 세 단계 이동 (그 다음부터 진행 할 수 있도록)
                    // continue 를 통해서 네 개를 먼저 검사하고 두 개를 검사할 수 있도록 제어
                    continue;
                }
            }

            if (i + 1 < board.length) {
                boolean X2 = board[i] == board[i + 1];

                if (X2 && board[i] == 'X') {
                    i += 1;
                    sb.append("BB");
                    continue;
                }
            }

            if (board[i] == '.') {
                sb.append(".");
            } else {
                // 치환되지 않은 X가 남아 있으므로 -1 출력
                sb = new StringBuilder("-1");
                break;
            }
        }
        System.out.println(sb.toString());

    }
}
