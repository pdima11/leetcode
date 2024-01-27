package io.github.pdima;

public class Task3LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] nextPositions = new int[128];

            int result = 0;
            for (int start = 0, end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                start = Math.max(start, nextPositions[ch]);
                result = Math.max(result, end - start + 1);
                nextPositions[ch] = end + 1;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abba")); // 2
        System.out.println(solution.lengthOfLongestSubstring("abcbcabb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("dvdf")); // 3
    }

}
