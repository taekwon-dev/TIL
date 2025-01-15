package problem_solving.leetcode.blind_75.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ps_2025_01_15 {

    public boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != parentheses.get(c)) {
                    return false;
                }
                stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
