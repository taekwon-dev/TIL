package problem_solving.leetcode.blind_75.valid_anagram;

public class ps_2024_12_29 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countChar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countChar[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            countChar[idx]--;

            if (countChar[idx] < 0) {
                return false;
            }
        }

        for (int count :  countChar) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
