package problem_solving.leetcode.blind_75;

public class LEET_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");


        if (s.isEmpty()) return true;
        if (s.length() == 0) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
