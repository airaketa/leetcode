package com.airaketa.leetcode.lc322;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] subCounts = new int[amount + 1];
        Arrays.fill(subCounts, amount + 1);
        subCounts[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j ++) {
                if (coins[j] <= i) {
                    subCounts[i] = Math.min(subCounts[i], subCounts[i - coins[j]] + 1);
                }
            }
        }
        return subCounts[amount] == amount + 1 ? -1 : subCounts[amount];
    }

    public static void main(String[] args)
    {
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
    }
}
