package com.airaketa.leetcode.lc575;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/distribute-candies/
 */

public class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        int max = candyType.length / 2;
        return Math.min(max, types.size());
    }
}