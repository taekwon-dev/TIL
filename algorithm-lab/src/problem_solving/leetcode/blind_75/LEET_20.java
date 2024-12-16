package problem_solving.leetcode.blind_75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class LEET_20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(){{
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
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
