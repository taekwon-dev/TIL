package problem_solving.leetcode.blind_75.group_anagrams;

import java.util.*;

public class ps_2025_01_15 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : strs) {
            int[] counter = new int[26];
            for (int i = 0; i < word.length(); i++) {
                counter[word.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(counter);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new LinkedList<>());
            }
            List<String> words = anagrams.get(key);
            words.add(word);
        }

        return new ArrayList<>(anagrams.values());
    }
}
