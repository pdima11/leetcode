package io.github.pdima;

import java.util.*;

public class Task49GroupAnagrams {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Integer, List<String>> result = new HashMap<>();

            for (String str: strs) {
                int[] alphabet = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    alphabet[str.charAt(i) - 'a']++;
                }

                int key = Arrays.hashCode(alphabet);
                if (result.containsKey(key)) {
                    result.get(key).add(str);
                } else {
                    result.put(key, new ArrayList<>(List.of(str)));
                }
            }

            return new ArrayList<>(result.values());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
