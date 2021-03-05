package com.airaketa.leetcode.lc160;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
        {
            return null;
        }
        Set<ListNode> nodesA = new HashSet<>();
        ListNode current = headA;
        do {
            nodesA.add(current);
        }
        while((current = current.next) !=null);

        current = headB;
        do {
            if (nodesA.contains(current))
            {
                return current;
            }
        }
        while((current = current.next) !=null);

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}