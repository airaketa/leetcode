package com.airaketa.leetcode.lc823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-trees-with-factors/
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int modulo = 1000000007;
        Arrays.sort(arr);
        long[] subCounts = new long[arr.length];
        Arrays.fill(subCounts, 1);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            index.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int secondMultiplier = arr[i] / arr[j];
                    if (index.containsKey(secondMultiplier)) {
                        subCounts[i] = (subCounts[i] + subCounts[j] * subCounts[index.get(secondMultiplier)]) % modulo;
                    }
                }
            }
        }

        long result = 0;
        for (long subCount : subCounts) {
            result += subCount;
        }
        return (int) (result % modulo);
    }
}