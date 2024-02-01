package io.github.pdima;

import java.util.LinkedList;

public class Task155MinStack {
    static class MinStack {
        private LinkedList<Integer> mins;
        private LinkedList<Integer> stack;


        public MinStack() {
            this.mins = new LinkedList<>();
            this.stack = new LinkedList<>();
        }

        public void push(int val) {
            int currentMin = !mins.isEmpty() ? mins.getLast() : val;
            mins.add(Math.min(val, currentMin));
            stack.add(val);
        }

        public void pop() {
            mins.removeLast();
            stack.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return mins.getLast();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(7);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(5);

        System.out.println(stack.top() + " - " + stack.getMin());
        stack.pop();
        System.out.println(stack.top() + " - " + stack.getMin());
        stack.pop();
        System.out.println(stack.top() + " - " + stack.getMin());
        stack.pop();
        System.out.println(stack.top() + " - " + stack.getMin());
        stack.pop();
        System.out.println(stack.top() + " - " + stack.getMin());
        stack.pop();
    }

}
