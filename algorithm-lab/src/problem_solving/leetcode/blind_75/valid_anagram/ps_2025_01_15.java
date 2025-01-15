package problem_solving.leetcode.blind_75.valid_anagram;

public class ps_2025_01_15 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[50_001];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            count[sChar - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            count[tChar - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
