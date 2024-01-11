package io.github.pdima;

import java.util.Stack;

public class Task232ImplementQueueUsingStacks {
    class MyQueue {
        private Stack<Integer> in  = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    Integer item = in.pop();
                    out.push(item);
                }
            }

            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

}
