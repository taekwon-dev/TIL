package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

public class LV1_비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        decode(map1, arr1);
        decode(map2, arr2);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 0 && map2[i][j] == 0) {
                    map1[i][j] = 0;
                } else if (map1[i][j] == 1 || map2[i][j] == 1) {
                    map1[i][j] = 1;
                }
            }
        }
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 0) {
                    sb.append(" ");
                } else if (map1[i][j] == 1) {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
            sb.delete(0, sb.length());
        }
        return answer;
    }

    private void decode(int[][] map, int[] arr) {
        for (int i = 0; i < map.length; i++) {
            int idx = map.length - 1;
            int j = arr[i];
            while (j >= 1) {
                map[i][idx--] = j % 2;
                j /= 2;
            }
        }
    }
}