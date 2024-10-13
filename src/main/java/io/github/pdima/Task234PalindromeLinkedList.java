package io.github.pdima;

public class Task234PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            while (slow != null) {
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            ListNode left = head;
            ListNode right = prev;
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(5);
        list1.next.next.next.next = new ListNode(2);
        list1.next.next.next.next.next = new ListNode(3);
        list1.next.next.next.next.next.next = new ListNode(1);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(5);
        list2.next.next.next.next = new ListNode(3);
        list2.next.next.next.next.next = new ListNode(2);
        list2.next.next.next.next.next.next = new ListNode(1);

        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(2);
        list3.next.next = new ListNode(2);
        list3.next.next.next = new ListNode(1);

        System.out.println(solution.isPalindrome(list1)); // false
        System.out.println(solution.isPalindrome(list2)); // true
        System.out.println(solution.isPalindrome(list3)); // true
        System.out.println(new ListNode(1)); // true
    }
}
