package io.github.pdima;

import java.util.HashMap;
import java.util.Map;

public class Task13RomanToInteger {
    static class Solution {
        public int romanToInt2(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char currentDigit = s.charAt(i);
                char prevDigit = i > 0 ? s.charAt(i - 1) : ' ';

                switch (currentDigit) {
                    case 'I' -> result += 1;
                    case 'V' -> {
                        if (prevDigit == 'I') {
                            result += 3;
                        } else {
                            result += 5;
                        }
                    }
                    case 'X' -> {
                        if (prevDigit == 'I') {
                            result += 8;
                        } else {
                            result += 10;
                        }
                    }
                    case 'L' -> {
                        if (prevDigit == 'X') {
                            result += 30;
                        } else {
                            result += 50;
                        }
                    }
                    case 'C' -> {
                        if (prevDigit == 'X') {
                            result += 80;
                        } else {
                            result += 100;
                        }
                    }
                    case 'D' -> {
                        if (prevDigit == 'C') {
                            result += 300;
                        } else {
                            result += 500;
                        }
                    }
                    case 'M' -> {
                        if (prevDigit == 'C') {
                            result += 800;
                        } else {
                            result += 1000;
                        }
                    }
                }
            }

            return result;
        }

        public int romanToInt(String s) {
            Map<Character, Integer> dict = new HashMap<>();
            dict.put('I', 1);
            dict.put('V', 5);
            dict.put('X', 10);
            dict.put('L', 50);
            dict.put('C', 100);
            dict.put('D', 500);
            dict.put('M', 1000);

            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 1 && dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1))) {
                    result -= dict.get(s.charAt(i));
                } else {
                    result += dict.get(s.charAt(i));
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("LVIII")); // 58
        System.out.println(solution.romanToInt("MCMXCIV")); // 1994
    }
}
