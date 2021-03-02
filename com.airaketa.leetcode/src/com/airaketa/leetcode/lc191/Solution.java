package com.airaketa.leetcode.lc191;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int k = 00000000000000000000000000000001;
        int count = 0;
        for (int i = 0; i < 32; i++)
        {
            if ((n & k) > 0)
            {
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }
}