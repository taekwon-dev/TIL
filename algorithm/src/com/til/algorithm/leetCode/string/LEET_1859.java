package com.til.algorithm.leetCode.string;

public class LEET_1859 {

    public String sortSentence(String s) {
        String[] word = s.split(" ");
        String[] candidate = new String[word.length];
        for (String w : word) {
            int idx = Integer.parseInt(w.substring(w.length() - 1));
            String val = w.substring(0, w.length() - 1);
            candidate[idx - 1] = val;
        }
        StringBuilder answer = new StringBuilder();
        for (String c : candidate) {
            answer.append(c).append(" ");
        }
        return answer.toString().trim();
    }
}