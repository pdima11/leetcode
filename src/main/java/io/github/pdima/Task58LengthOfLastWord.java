package io.github.pdima;

public class Task58LengthOfLastWord {

    static class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length() - 1;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int result = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                result++;
                i--;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLastWord("Hello World")); // 5
        System.out.println(solution.lengthOfLastWord("Hello, my name is John  ")); // 4
        System.out.println(solution.lengthOfLastWord("dd")); // 2
        System.out.println(solution.lengthOfLastWord("   ")); // 0
    }
}
