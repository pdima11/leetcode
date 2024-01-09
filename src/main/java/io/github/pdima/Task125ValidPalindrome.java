package io.github.pdima;

public class Task125ValidPalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);

                if (!Character.isLetterOrDigit(ch1)) {
                    i++;
                    continue;
                }

                if (!Character.isLetterOrDigit(ch2)) {
                    j--;
                    continue;
                }

                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                i++;
                j--;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.isPalindrome("");
        assert solution.isPalindrome(" ");
        assert solution.isPalindrome("a");
        assert solution.isPalindrome("a bb a");
        assert solution.isPalindrome("A man, a plan, a canal: Panama");
        assert solution.isPalindrome("race e car");
        assert solution.isPalindrome("race ae car");

        assert solution.isPalindrome("race eae car");
        assert solution.isPalindrome("a - b");
    }

}
