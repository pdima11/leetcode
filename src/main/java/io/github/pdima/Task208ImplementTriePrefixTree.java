package io.github.pdima;

import java.util.HashMap;
import java.util.Map;

public class Task208ImplementTriePrefixTree {
    static class Trie {
        private static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
        }

        private TrieNode root = new TrieNode();
        private final char endSymbol = '*';

        public Trie() {

        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }
                current = current.children.get(ch);

            }
            current.children.put(endSymbol, null);
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }

            return current.children.containsKey(endSymbol);
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }

            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.search("apple")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

}
