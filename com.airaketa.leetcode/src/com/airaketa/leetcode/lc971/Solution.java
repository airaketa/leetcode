package com.airaketa.leetcode.lc971;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */
class Solution {
    private int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> flip = new ArrayList();
        index = 0;
        voyage(root, flip, voyage);
        if (!flip.isEmpty() && flip.get(0) == -1) {
            return List.of(-1);
        }
        return flip;
    }

    public void voyage(TreeNode node, List<Integer> flip, int[] voyage) {
        if (node != null) {
            if (node.val != voyage[index++]) {
                flip.clear();
                flip.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
                flip.add(node.val);
                voyage(node.right, flip, voyage);
                voyage(node.left, flip, voyage);
            } else {
                voyage(node.left, flip, voyage);
                voyage(node.right, flip, voyage);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}