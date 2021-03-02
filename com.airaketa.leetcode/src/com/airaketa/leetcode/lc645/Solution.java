package com.airaketa.leetcode.lc645;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
class Solution {
    public static int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int doubled = 0;
        int absent = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (++count[nums[i] - 1] == 2)
            {
                doubled = nums[i];
            }
        }
        for (int i = 0; i < count.length; i++)
        {
            if (count[i] == 0)
            {
                absent = i + 1;
                break;
            }
        }
        return new int[]{doubled, absent};
    }
}