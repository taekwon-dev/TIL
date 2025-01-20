package problem_solving.leetcode.blind_75.group_anagrams;

import java.util.*;

public class ps_2025_01_20 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        if (strs.length == 0) {
            return answer;
        }

        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new LinkedList<>());
            }
            List<String> words = anagramsMap.get(key);
            words.add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}
