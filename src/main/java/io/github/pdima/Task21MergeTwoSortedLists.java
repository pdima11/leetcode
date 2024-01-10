package io.github.pdima;

public class Task21MergeTwoSortedLists {

     static public class ListNode {
         int val;
         ListNode next;
         public ListNode() {};
         public ListNode(int val) { this.val = val; }
         public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = new ListNode();

            ListNode current = result;
            ListNode current1 = list1;
            ListNode current2 = list2;
            while (current1 != null && current2 != null) {
                if (current1.val <= current2.val) {
                    current.next = current1;
                    current1 = current1.next;
                } else {
                    current.next = current2;
                    current2 = current2.next;
                }
                current = current.next;
            }

            current1 = current1 != null ? current1 : current2;
            current.next = current1;

            return result.next;
        }

         public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
             if (list1 == null) {
                 return list2;
             }
             if (list2 == null) {
                 return list1;
             }

             if (list1.val <= list2.val) {
                 list1.next = mergeTwoLists(list1.next, list2);
                 return list1;
             } else {
                 list2.next = mergeTwoLists(list1, list2.next);
                 return list2;
             }
         }
    }
}
