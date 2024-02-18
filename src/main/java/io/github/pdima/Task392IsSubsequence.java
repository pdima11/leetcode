package io.github.pdima;

public class Task392IsSubsequence {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int j = 0;
            for (int i = 0; i < t.length(); i++) {
                if (j < s.length() && s.charAt(j) == t.charAt(i)) {
                    j++;
                }
            }

            return j == s.length();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isSubsequence("abc", "aabbcd")); // true
        System.out.println(solution.isSubsequence("a", "dcba")); // true
        System.out.println(solution.isSubsequence("", "dcba")); // true
        System.out.println(solution.isSubsequence("aabbcc", "")); // false
        System.out.println(solution.isSubsequence("f", "aabbcc")); // false
    }
}
