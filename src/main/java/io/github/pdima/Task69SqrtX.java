package io.github.pdima;

public class Task69SqrtX {
    static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) {
                return x;
            }
            long left = 1;
            long right = x;
            while (left <= right) {
                long m = left + (right - left) / 2;
                if (m * m > x) {
                    right = m - 1;
                } else if (m * m < x) {
                    left = m + 1;
                } else {
                    return (int) m;
                }
            }

            return (int) right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.mySqrt(0));
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(2147483647));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(25));
    }

}
