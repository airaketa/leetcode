package com.airaketa.leetcode.lc623;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1)
        {
            return new TreeNode(v, root, null);
        }
        else {
            traverseNodes(root, v, 0, d - 1);
        }
        return root;
    }

    private void traverseNodes(TreeNode current, int v, int depth, int targetDepth)
    {
        if (depth == targetDepth -1) {
            current.left = new TreeNode(v, current.left, null);
            current.right = new TreeNode(v, null, current.right);
        }
        else
        {
            if (current.left != null) {
                traverseNodes(current.left, v, depth + 1, targetDepth);
            }
            if (current.right != null) {
                traverseNodes(current.right, v,depth + 1, targetDepth);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
