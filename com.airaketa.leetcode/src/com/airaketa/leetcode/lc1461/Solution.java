package com.airaketa.leetcode.lc1461;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int[] checks = new int[(int) Math.pow(2, k)];
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            checks[Integer.parseInt(substring, 2)] = 1;
        }

        for (int check : checks) {
            if (check == 0) {
                return false;
            }
        }
        return true;
    }
}