package io.github.pdima;

public class Task242ValidAnagram {

    static class Solution {
        public boolean isAnagram(String s, String t) {
            char[] chars = new char[52];

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                chars[ch - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                chars[ch - 'a']--;
            }

            for (char ch: chars) {
                if (ch != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("car", "race"));
        System.out.println(solution.isAnagram("anagram", "gramana"));
    }
}
