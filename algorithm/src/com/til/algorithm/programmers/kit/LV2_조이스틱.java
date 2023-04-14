package com.til.algorithm.programmers.kit;

public class LV2_조이스틱 {

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int endA = i + 1;
                while (endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }
                move = Math.min(move, i * 2 + (name.length() - endA));
                move = Math.min(move, i + (name.length() - endA) * 2);
            }

        }
        return answer + move;
    }
}