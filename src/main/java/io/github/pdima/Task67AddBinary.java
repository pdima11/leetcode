package io.github.pdima;

public class Task67AddBinary {

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();

            int carry = 0;
            int i = a.length() - 1;
            int j = b.length() - 1;
            while (i >= 0 || j >= 0) {
                int sum = carry;

                if (i >= 0) {
                    sum += a.charAt(i--) - '0';
                }
                if (j >= 0) {
                    sum += b.charAt(j--) - '0';
                }

                carry = sum > 1 ? 1 : 0;
                sb.append(sum % 2);
            }

            if (carry > 0) {
                sb.append(carry);
            }

            return sb.reverse().toString();
        }
    }

    public String addBinary2(String a, String b) {
        String small = a.length() < b.length() ? a : b;
        String big = a.length() >= b.length() ? a : b;

        boolean rest = false;
        char result = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = small.length() - 1; i >= 0; i--) {
            char bit1 = small.charAt(i);
            char bit2 = big.charAt(i + (big.length() - small.length()));
            if (bit1 != bit2) {
                result = rest ? '0' : '1';
            } else {
                result = rest ? '1' : '0';
                rest = bit1 == '1';
            }

            sb.append(result);
        }

        for (int i = big.length() - small.length() - 1; i >= 0; i--) {
            if (rest) {
                result = big.charAt(i) == '1' ? '0' : '1';
                rest = big.charAt(i) == '1';
            } else {
                result = big.charAt(i);
            }
            sb.append(result);
        }

        if (rest) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.addBinary("110101", "100")); // 111001
        System.out.println(solution.addBinary("11111", "111")); // 100110
        System.out.println(solution.addBinary("110010", "10111")); // 1001001
    }

}
