package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

public class LV1_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] arr = new int[3];
        int idx = 0;
        String buffer = "";
        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    arr[idx] = (int) Math.pow(Integer.parseInt(buffer), 1);
                    idx++;
                    buffer = "";
                    break;
                case 'D':
                    arr[idx] = (int) Math.pow(Integer.parseInt(buffer), 2);
                    idx++;
                    buffer = "";
                    break;
                case 'T':
                    arr[idx] = (int) Math.pow(Integer.parseInt(buffer), 3);
                    idx++;
                    buffer = "";
                    break;
                case '*':
                    arr[idx - 1] *= 2;
                    if (idx > 1) {
                        arr[idx - 2] *= 2;
                    }
                    break;
                case '#':
                    arr[idx - 1] *= -1;
                    break;
                default:
                    buffer += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }
        for (int i : arr) {
            answer += i;
        }
        return answer;
    }
}
