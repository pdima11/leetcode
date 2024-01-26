package io.github.pdima;

import java.util.HashMap;
import java.util.Map;

public class Task205IsomorphicStrings {

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] charCounts1 = new int[256];
            int[] charCounts2 = new int[256];

            for (int i = 0; i < s.length(); i++) {
                if (charCounts1[s.charAt(i)] != charCounts2[t.charAt(i)]) {
                    return false;
                }
                charCounts1[s.charAt(i)] = i + 1;
                charCounts2[t.charAt(i)] = i + 1;
            }

            return true;
        }

        public boolean isIsomorphic2(String s, String t) {
            return check(s, t) && check(t, s);
        }

        private boolean check(String s1, String s2) {
            Map<Character, Character> mapping = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                if (mapping.containsKey(s1.charAt(i))) {
                    if (mapping.get(s1.charAt(i)) != s2.charAt(i)) {
                        return false;
                    }
                } else {
                    mapping.put(s1.charAt(i), s2.charAt(i));
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isIsomorphic("paper", "title")); // true
        System.out.println(solution.isIsomorphic("bada", "baba")); // false
    }

}
