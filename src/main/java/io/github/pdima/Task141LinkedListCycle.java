package io.github.pdima;

public class Task141LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        System.out.println(solution.hasCycle(head));

        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = head.next.next;

        System.out.println(solution.hasCycle(head));
    }
}