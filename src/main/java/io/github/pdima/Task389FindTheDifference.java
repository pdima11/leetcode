package io.github.pdima;

public class Task389FindTheDifference {
    static class Solution {
//        public char findTheDifference(String s, String t) {
//            int[] chars = new int[26];
//
//            for (int i = 0; i < t.length(); i++) {
//                chars[t.charAt(i) - 'a'] += 1;
//                if (i < s.length()) {
//                    chars[s.charAt(i) - 'a'] -= 1;
//
//                }
//            }
//
//            char result = 'a';
//            for (int i = 0; i < chars.length; i++) {
//                if (chars[i] > 0) {
//                    result = (char) (i + 'a');
//                    break;
//                }
//            }
//
//            return result;
//        }

        public char findTheDifference(String s, String t) {
            int diff = 0;

            for (int i = 0; i < t.length(); i++) {
                diff += t.charAt(i);
                if (i < s.length()) {
                    diff -= s.charAt(i);
                }
            }

            return (char) diff;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findTheDifference("a", "aa")); // a
        System.out.println(solution.findTheDifference("abcdbd", "addfbcb")); // f
        System.out.println(solution.findTheDifference("aaa", "acaa")); // c
        System.out.println(solution.findTheDifference("assa", "aasss")); // s
    }
}
