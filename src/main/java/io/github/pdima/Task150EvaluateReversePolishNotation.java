package io.github.pdima;

import java.util.Stack;

public class Task150EvaluateReversePolishNotation {

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String token: tokens) {
                if (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    int num1 = stack.pop();
                    int num2 = stack.pop();

                    switch (token) {
                        case "+" -> stack.push(num2 + num1);
                        case "-" -> stack.push(num2 - num1);
                        case "*" -> stack.push(num2 * num1);
                        case "/" -> stack.push(num2 / num1);
                    }
                }
            }

            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.evalRPN(new String[]{"4", "6", "*", "1", "+"})); // 25
        System.out.println(solution.evalRPN(new String[]{"5", "5", "6", "*", "-"})); // -25
    }
}
