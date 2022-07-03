package com.til.algorithm.이코테.ch6_dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Youn on 2022/05/17.
 * Title : 모험가 길드 (https://youtu.be/2zjoKjt97vQ?list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&t=1427)
 * Hint  :
 */
public class 모험가길드 {
    public static int n;
    public static ArrayList<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrList.add(sc.nextInt());
        }
        // 오름차순 정렬
        Collections.sort(arrList);

        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += 1;
            if (count >= arrList.get(i)) {
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
