package com.airaketa.leetcode.lc637;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>(); // count of nodes on each level (level == index)
        List<Double> avg = new ArrayList<>(); // avg for each level (level == index)
        processNode(0, count, avg, root);
        return avg;
    }

    private void processNode(int recursionLevel, List<Integer> count, List<Double> avg, TreeNode currentNode)
    {
        incrementCount(count, recursionLevel);
        recomputeAvg(avg, count, recursionLevel, currentNode.val);
        if (currentNode.left != null)
        {
            processNode(recursionLevel + 1, count, avg, currentNode.left);
        }
        if (currentNode.right != null)
        {
            processNode(recursionLevel + 1, count, avg, currentNode.right);
        }
    }

    private void incrementCount(List<Integer> count, int level)
    {
        if (count.size() <= level)
        {
            count.add(1);
        }
        else
        {
            count.set(level, count.get(level) + 1);
        }
    }

    private void recomputeAvg(List<Double> avg, List<Integer> count, int level, int value)
    {
        if (avg.size() <= level)
        {
            avg.add(value * 1.0);
        }
        else
        {
            // avg2 = ((avg1 * n) + a) / (n + 1)
            double oldAvg = avg.get(level);
            int levelCount = count.get(level);
            double newAvg = (oldAvg * (levelCount - 1) + value) / levelCount;
            avg.set(level, newAvg);
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