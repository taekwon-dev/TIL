package com.til.algorithm.leetCode.string;

public class LEET_1108 {

    public String defangIPaddr(String address) {
        StringBuilder answer = new StringBuilder();
        String[] addressSplit = address.split("\\.");
        int len = addressSplit.length;
        for (int i = 0; i < len - 1; i++) {
            answer.append(addressSplit[i]).append("[.]");
        }
        answer.append(addressSplit[len - 1]);
        return answer.toString();
    }
}