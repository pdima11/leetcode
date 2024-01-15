package io.github.pdima;

public class Task206ReverseLinkedList {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head.next;
            ListNode newHead = head;
            newHead.next = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = newHead;
                newHead = current;
                current = temp;
            }

            return newHead;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseList(head).val); // 5
    }
}
