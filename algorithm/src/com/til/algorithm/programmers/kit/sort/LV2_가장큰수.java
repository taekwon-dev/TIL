package com.til.algorithm.programmers.kit.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LV2_가장큰수 {

    /**
     *  0 또는 양의 정수 (= 0 포함 자연수 범위), 이어 붙여 만들 수 있는 가장 큰 수 만들기
     *  numbers 길이가 최대 100,000 이므로, 백트랙킹 (순열)으로 완전탐색 시 100,000! -> 이 방식으로 접근하지 말아야 하는 Sign
     *
     *
     *  가장 큰 수를 만들기 위해서는 0 ~ 1000 수에서 앞자리가 제일 큰 수가 앞으로 와야한다. (각 요소의 수 비교 -> 각 요소의 앞자리 비교)
     *
     *  0 ~ 1000 범위,
     *  1의 자리 구하기
     *  10의 자리 구하기
     *  100의 자리 구하기
     *  1000의 자리 구하기
     *
     *  ex) 19 / 10 = 1 (10의 자리 - 몫), 19 % 10 = 9 (1의 자리 - 나머지)
     *  ex) 198 / 100 = 1 (100의 자리 - 몫), 198 % 100 = 98 -> 위 과정을 돌리면 10, 1의 자리 구할 수 있다.
     *
     *  -> 100,000 수의 맨 앞자리를 구하고, 맨 앞자리가 가장 큰 수인 요소가 여러 개인 경우를 또 고려해야 함. -> 최종적으로 1000 단위에서 1 단위 까지 모두 비교해야 할 수 도 있음
     *  999 998 997 996 (앞 자리 후보) -> 10의 자리 비교 -> 1의 자리 비교 ...
     *
     *  a, b, c, d, e (string)
     *
     *  a + b vs b + a => 큰 수 (b + a로 가정)
     *  (b + a) + c vs c + (b + a) => 큰수 (c + (b + a))
     *  (c + (b + a)) + d vs d + (c + (a + b))
     */

    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (arr[0].equals("0")) {
            return "0";
        }

        for (String str : arr) {
            answer += str;
        }
        return answer;
    }
}
