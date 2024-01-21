package io.github.pdima;

public class Task191NumberOf1Bits {

    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count += n & 1;
                n = n >>> 1;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingWeight(2)); // 1
        System.out.println(solution.hammingWeight(15)); // 4
        System.out.println(solution.hammingWeight(16)); // 1
        System.out.println(solution.hammingWeight(-3)); // 31
    }
}
