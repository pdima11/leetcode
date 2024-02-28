package io.github.pdima;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task290WordPattern {
    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (words.length != pattern.length()) {
                return false;
            }

            Map<Character, String> mappings = new HashMap<>();
            Set<String> blacklist = new HashSet<>();

            for (int i = 0; i < words.length; i++) {
                char ch = pattern.charAt(i);
                if (!mappings.containsKey(ch) && !blacklist.contains(words[i])) {
                    mappings.put(ch, words[i]);
                    blacklist.add(words[i]);
                } else {
                    String word = mappings.get(ch);
                    if (!words[i].equals(word)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // false
        System.out.println(solution.wordPattern("abb", "cat dog")); // false
    }

}
