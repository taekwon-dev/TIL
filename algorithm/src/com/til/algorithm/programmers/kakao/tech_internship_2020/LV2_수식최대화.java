package com.til.algorithm.programmers.kakao.tech_internship_2020;

import java.util.LinkedList;
import java.util.List;

public class LV2_수식최대화 {

    private String expression;
    private long max = 0;

    public long solution(String expression) {
        this.expression = expression;
        permutation(0, 3, new String[]{"+", "-", "*"}, new boolean[3], "");
        return max;
    }

    /**
     *   연산자('+', '-', '*') 우선순위 지정 = 백트랙킹 + 순열
     */
    public void permutation(int startDept, int targetDepth, String[] arr, boolean[] check, String result) {
        if (startDept == targetDepth) {
            calc(result);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation(startDept + 1, targetDepth, arr, check, result + arr[i]);
                    check[i] = false;
                }
            }
        }
    }

    public void calc(String operator) {
        StringBuilder post = new StringBuilder();
        List<Long> operandList = new LinkedList<>();
        List<String> operatorList = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                operandList.add(Long.parseLong(post.toString()));
                post = new StringBuilder();
                operatorList.add(String.valueOf(expression.charAt(i)));
            } else
                post.append(expression.charAt(i));
        }

        operandList.add(Long.parseLong(post.toString()));

        for (int i = 0; i < 3; i++) {
            String nowOperator = String.valueOf(operator.charAt(i));

            while(operatorList.size() != 0){
                int index = operatorList.indexOf(nowOperator);

                if(index == -1)
                    break;
                else{
                    switch (nowOperator){
                        case "+":
                            operandList.add(index, operandList.get(index) + operandList.get(index + 1));
                            break;
                        case "-":
                            operandList.add(index, operandList.get(index) - operandList.get(index + 1));
                            break;
                        case "*":
                            operandList.add(index, operandList.get(index) * operandList.get(index + 1));
                            break;
                    }
                    operandList.remove(index + 1);
                    operandList.remove(index + 1);
                    operatorList.remove(index);
                }
            }
        }

        max = Math.max(max, Math.abs(operandList.get(0)));
    }
}