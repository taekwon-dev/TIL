package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.Arrays;

public class LV2_파일명정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0];
            String head2 = o2.split("[0-9]")[0];

            int result = head1.toLowerCase().compareTo(head2.toLowerCase());
            if (result == 0) {
                result = getNumber(o1, head1) - getNumber(o2, head2);
            }
            return result;
        });


        return files;
    }

    private int getNumber(String file, String head) {
        file = file.replaceFirst(head, "");
        String number = "";
        for (char c : file.toCharArray()) {
            if (Character.isDigit(c)  && number.length() < 5) {
                number += c;
            } else {
                break;
            }
        }
        return Integer.valueOf(number);
    }
}
