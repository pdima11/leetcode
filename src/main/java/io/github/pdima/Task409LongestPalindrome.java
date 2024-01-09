package io.github.pdima;

import java.util.HashSet;
import java.util.Set;

public class Task409LongestPalindrome {
    static class Solution {
        public int longestPalindrome(String s) {
            Set<Character> chars = new HashSet<>();

            int result = 0;
            for (Character ch: s.toCharArray()) {
                if (chars.contains(ch)) {
                    result += 2;
                    chars.remove(ch);
                } else {
                    chars.add(ch);
                }
            }

            return result + (chars.isEmpty() ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.longestPalindrome("") == 0;
        assert solution.longestPalindrome("abcdef") == 1;
        assert solution.longestPalindrome("a") == 1;
        assert solution.longestPalindrome("aa") == 2;
        assert solution.longestPalindrome("aaa") == 3;
        assert solution.longestPalindrome("ababa") == 5;
        assert solution.longestPalindrome("ababac") == 6;
        assert solution.longestPalindrome("abccccdd") == 7;
    }
}
