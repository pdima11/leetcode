package io.github.pdima;

public class Task9PalindromeNumber {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int input = x;
            int reversed = 0;
            while (x > 0) {
                int remainder = x % 10;
                reversed = reversed * 10 + remainder;
                x = x / 10;
            }

            return input == reversed;
        }
    }

    public static void main(String[] args) {
        Task9PalindromeNumber.Solution solution = new Task9PalindromeNumber.Solution();
        System.out.println(solution.isPalindrome(1221)); // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(3)); // true
        System.out.println(solution.isPalindrome(124)); // false
    }
}
