package com.airaketa.leetcode.lc895;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */

class FreqStack {
    private final List<List<Integer>> stack; // first dimension - count, second dimension - numbers of this count
    private int maxCount;

    public FreqStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        for (int i = 0; i < stack.size(); i++)
        {
            List<Integer> numbers = stack.get(i);
            if (!numbers.contains(x))
            {
                numbers.add(x);
                return;
            }
        }
        List<Integer> newNumbers = new ArrayList<>();
        newNumbers.add(x);
        stack.add(newNumbers);
        maxCount++;
    }

    public int pop() {
        List<Integer> mostFrequentNumbers = stack.get(stack.size() - 1);
        int lastIndex = mostFrequentNumbers.size() - 1;
        int number = mostFrequentNumbers.get(lastIndex);
        mostFrequentNumbers.remove(lastIndex);
        if (mostFrequentNumbers.isEmpty())
        {
            stack.remove(stack.size() - 1);
        }
        return number;
    }
}