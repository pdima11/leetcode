package io.github.pdima;

import java.util.Stack;

public class Task20ValidParentheses {

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char prev = stack.pop();
                    if (!((prev == '(' && ch == ')') || (prev == '[' && ch == ']') || (prev == '{' && ch == '}'))) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }

        public boolean isValid2(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i);
                if (ch == '[') {
                    stack.push(']');
                } else if (ch == '(') {
                    stack.push(')');
                } else if (ch == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("[]((})"));
        System.out.println(solution.isValid("]]](){}[[["));
        System.out.println(solution.isValid("[(){(()([{}[]]))}]"));
    }

}
