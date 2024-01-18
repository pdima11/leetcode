package io.github.pdima;

public class Task14LongestCommonPrefix {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int minLength = Integer.MAX_VALUE;

            for (String str: strs) {
                if (strs.length < minLength) {
                    minLength = str.length();
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minLength; i++) {
                char current = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (current != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(current);
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "cat", "horse"})); // ""
    }

}
