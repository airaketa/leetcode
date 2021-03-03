package com.airaketa.leetcode.lc1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMaps = new HashMap<>(); // key - number, value - index
        for (int i = 0; i < nums.length; i++)
        {
            int missingSummand = target - nums[i];
            if (numsMaps.containsKey(missingSummand))
            {
                return new int[]{ numsMaps.get(missingSummand), i };
            }
            numsMaps.put(nums[i], i);
        }
        return new int[]{};
    }
}