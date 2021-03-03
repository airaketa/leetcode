package com.airaketa.leetcode.lc122;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy = -1;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (buy == -1 && prices[i + 1] > prices[i]) {
                buy = prices[i];
            }
            if (buy != -1 && prices[i + 1] < prices[i] && prices[i] > buy) {
                profit += prices[i] - buy;
                buy = -1;
            }
        }
        if (buy != -1 && prices[prices.length - 1] > buy) {
            profit += prices[prices.length - 1] - buy;
        }
        return profit;
    }
}
