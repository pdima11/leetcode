package io.github.pdima;

import java.util.Arrays;

public class Task338CountingBits {
    static class Solution {

        public int[] countBits(int n) {
            int[] result = new int[n + 1];

            result[0] = 0;
            for (int i = 1; i < n + 1; i++) {
                result[i] = result[i >> 1] + (i & 1);
            }

            return result;
        }

        public int[] countBits2(int n) {
            int[] result = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                result[i] = getNumberOfOnes(i);
            }

            return result;
        }

        private int getNumberOfOnes(int num) {
            int count = 0;
            while (num != 0) {
                int ans = num / 2;
                if (ans * 2 != num) {
                    count++;
                }
                num = ans;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.countBits(5))); // [0,1,1,2,1,2]
    }
}
