package com.airaketa.leetcode.lc26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[--length] = 0;
                i--;
            }
        }
        return length;
    }
}