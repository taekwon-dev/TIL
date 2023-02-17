package com.til.algorithm.programmers.summer_winter_coding;

public class LV2_스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            String temp = skill_tree;
            for (int i = 0; i < skill_tree.length(); i++) {
                String c = skill_tree.substring(i, i + 1);
                if (!skill.contains(c)) {
                    temp = temp.replace(c, "");
                }
            }
            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }
        return answer;
    }
}
