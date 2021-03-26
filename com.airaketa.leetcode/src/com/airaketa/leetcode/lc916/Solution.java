package com.airaketa.leetcode.lc916;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/
 */
class Solution {
    public List<String> wordSubsets(String[] a, String[] b) {
        int size = 'z' - 'a' + 1;
        int[] bMaxLetters = new int[size];

        for (String bWord : b) {
            int[] bWordLetters = new int[size];
            for (char bLetter : bWord.toCharArray()) {
                bWordLetters[bLetter - 'a']++;
            }
            for (int i = 0; i < size; i++) {
                if (bWordLetters[i] > bMaxLetters[i]) {
                    bMaxLetters[i] = bWordLetters[i];
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String aWord : a) {
            int[] aWordLetters = new int[size];
            for (char aLetter : aWord.toCharArray()) {
                aWordLetters[aLetter - 'a']++;
            }
            for (int i = 0; i < size; i++) {
                if (aWordLetters[i] < bMaxLetters[i]) {
                    break;
                }
                if (i == size - 1) {
                    result.add(aWord);
                }
            }
        }

        return result;
    }
}