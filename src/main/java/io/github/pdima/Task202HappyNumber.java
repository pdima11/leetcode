package io.github.pdima;

import java.util.HashSet;
import java.util.Set;

public class Task202HappyNumber {
    static class Solution {

        public boolean isHappy(int n) {
            int slow = squareDigits(n);
            int fast = squareDigits(squareDigits(n));

            while (slow != fast) {
                slow = squareDigits(slow);
                fast = squareDigits(squareDigits(fast));
            }

            return slow == 1;
        }


        public boolean isHappy2(int n) {
            Set<Integer> squaredNumbers = new HashSet<>();
            while (n != 1 && !squaredNumbers.contains(n)) {
                squaredNumbers.add(n);
                n = squareDigits(n);
            }

            return n == 1;
        }

        private int squareDigits(int n) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy2(2));
        System.out.println(solution.isHappy2(19));

        System.out.println(solution.isHappy(2));
        System.out.println(solution.isHappy(19));
    }
}
