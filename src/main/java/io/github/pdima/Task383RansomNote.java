package io.github.pdima;

public class Task383RansomNote {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] alphabet = new int[26];

            for (int i = 0; i < ransomNote.length(); i++) {
                alphabet[ransomNote.charAt(i) - 'a']++;
            }

            for (int i = 0; i < magazine.length(); i++) {
                alphabet[magazine.charAt(i) - 'a']--;
            }

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] > 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canConstruct("aabc", "abcabc"));
        System.out.println(solution.canConstruct("mycar", "mycat"));
    }

}
