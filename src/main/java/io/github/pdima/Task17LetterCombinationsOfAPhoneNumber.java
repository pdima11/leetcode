package io.github.pdima;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task17LetterCombinationsOfAPhoneNumber {
    static class Solution {
        private static final Map<Character, String> digitToChars = new HashMap<>();
        static {
            digitToChars.put('2', "abc");
            digitToChars.put('3', "def");
            digitToChars.put('4', "ghi");
            digitToChars.put('5', "jkl");
            digitToChars.put('6', "mno");
            digitToChars.put('7', "pqrs");
            digitToChars.put('8', "tuv");
            digitToChars.put('9', "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            List<String> results = new ArrayList<>();
            if (digits.isEmpty()) {
                return results;
            }

            backtrack(0, new StringBuilder(), digits, results);
            return results;
        }

        private void backtrack(int index, StringBuilder result, String digits, List<String> results) {
            if (index == digits.length()) {
                results.add(result.toString());
                return;
            }
            String chars = digitToChars.get(digits.charAt(index));

            for (int i = 0; i < chars.length(); i++) {
                result.append(chars.charAt(i));
                backtrack(index + 1, result, digits, results);
                result.setLength(result.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.letterCombinations("")); // []
        System.out.println(solution.letterCombinations("4")); // ["g", "h", "i"]
        System.out.println(solution.letterCombinations("23")); // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }

}
