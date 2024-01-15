package io.github.pdima;


public class Task876MiddleOfTheLinkedList {

     static public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public ListNode middleNode2(ListNode head) {
            int length = 0;
            ListNode current = head;
            while (current != null) {
                length++;
                current = current.next;
            }

            int middle = length / 2;
            current = head;
            while (middle > 0) {
                middle--;
                current = current.next;
            }

            return current;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.middleNode(head).val); // 3

        head.next.next.next.next.next = new ListNode(6);
        System.out.println(solution.middleNode(head).val); // 4
    }
}
