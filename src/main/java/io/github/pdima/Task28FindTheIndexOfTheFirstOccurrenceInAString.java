package io.github.pdima;

public class Task28FindTheIndexOfTheFirstOccurrenceInAString {
    static class Solution {
        public int strStr(String haystack, String needle) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j = 0;
                while (j < needle.length() && needle.charAt(j) == haystack.charAt(i + j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.strStr("mississippi", "issipi")); // -1
        System.out.println(solution.strStr("aaa", "aaaa")); // -1
        System.out.println(solution.strStr("mississippi", "issip")); // 4
    }
}
