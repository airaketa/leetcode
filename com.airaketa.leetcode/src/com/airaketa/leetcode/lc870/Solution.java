package com.airaketa.leetcode.lc870;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/advantage-shuffle/
 */
class Solution {
    public int[] advantageCount(int[] a, int[] b) {
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        List<Integer> aList = Arrays.stream(a)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < b.length; i++) {
            res[i] = aList.get(0);
            boolean found = false;
            for (int j = 0; j < aList.size(); j++) {
                int number = aList.get(j);
                if (number > b[i]) {
                    found = true;
                    res[i] = number;
                    aList.remove(j);
                    break;
                }
            }
            if (!found) {
                aList.remove(0);
            }
        }
        return res;
    }
}