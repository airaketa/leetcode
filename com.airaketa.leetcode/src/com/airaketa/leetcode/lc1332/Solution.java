package com.airaketa.leetcode.lc1332;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (isPalindrome(s)) {
            return 1;
        }
        return 2;
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i ++) {
            if (s.charAt(i) != s.charAt(length - i - 1))
            {
                return false;
            }
        }
        return true;
    }
}