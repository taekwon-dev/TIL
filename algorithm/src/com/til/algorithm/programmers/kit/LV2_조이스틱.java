package com.til.algorithm.programmers.kit;

public class LV2_조이스틱 {

    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len-1;

        for(int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int lastA = i + 1;
            while(lastA < len && name.charAt(lastA) =='A'){
                lastA++;
            }
            move = Math.min(move, i + (len - lastA) + Math.min(i, len - lastA));
        }
        answer += move;
        return answer;
    }
}