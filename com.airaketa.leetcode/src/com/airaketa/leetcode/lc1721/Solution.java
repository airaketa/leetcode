package com.airaketa.leetcode.lc1721;

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
class Solution {

    public ListNode swapNodes(ListNode head, int k) {
        int i = 1;
        ListNode first = head;
        ListNode last = head;
        ListNode current = head;
        while (current != null) {
            if (i == k) {
                first = current;
            }
            else if (i > k) {
                last = last.next;
            }
            i++;
            current = current.next;
        }
        int buf = first.val;
        first.val = last.val;
        last.val = buf;
        return head;
    }

//        public ListNode swapNodes(ListNode head, int k) {
//        List<Integer> nodes = new ArrayList<>();
//
//        ListNode current = head;
//        while (current != null) {
//            nodes.add(current.val);
//            current = current.next;
//        }
//
//        int firstIndex = k - 1;
//        int lastIndex = nodes.size() - k;
//        int first = nodes.get(firstIndex);
//        int last = nodes.get(lastIndex);
//
//        nodes.set(lastIndex, first);
//        nodes.set(firstIndex, last);
//
//        ListNode newHead = new ListNode(nodes.get(0));
//        current = newHead;
//        for (int i = 1; i < nodes.size(); i++) {
//            ListNode next = new ListNode(nodes.get(i));
//            current.next = next;
//            current = next;
//        }
//        return newHead;
//    }

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
}