package com.airaketa.leetcode.lc268;

/**
 * https://leetcode.com/problems/missing-number/
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums)
        {
            sum += n;
        }

        int controlsum = 0;
        for (int i = 0; i < nums.length + 1; i++)
        {
            controlsum+=i;
        }
        return controlsum - sum;
    }
}