package io.github.pdima;

public class Task1768MergeStringsAlternately {
    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            int l1 = word1.length();
            int l2 = word2.length();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < l1 || i < l2; i++) {
                if (i < l1) {
                    result.append(word1.charAt(i));
                }
                if (i < l2) {
                    result.append(word2.charAt(i));
                }
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.mergeAlternately("ab", "yz")); //aybz
        System.out.println(solution.mergeAlternately("abcw", "yz")); //aybzcw
        System.out.println(solution.mergeAlternately("ab", "yzeeef")); //aybzeeef
    }

}
