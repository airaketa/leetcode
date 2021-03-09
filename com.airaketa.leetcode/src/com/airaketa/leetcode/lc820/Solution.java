package com.airaketa.leetcode.lc820;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        String result = "";
        for (String word : words)
        {
            String encodedWord = word + '#';
            if (!result.contains(encodedWord))
            {
                result += encodedWord;
            }
        }
        return result.length();
    }

//    public int minimumLengthEncoding(String[] words) {
//        String result = "";
//        for (String word : words)
//        {
//            String encodedWord = word + '#';
//            if (!result.contains(encodedWord))
//            {
//                String subWordToReplace = result.isEmpty() ? null : wordContainsPartOfResult(encodedWord, result);
//                if (subWordToReplace == null)
//                {
//                    result += encodedWord;
//                }
//                else
//                {
//                    result = result.replace(subWordToReplace, encodedWord);
//                }
//            }
//        }
//        return result.length();
//    }
//
//    private String wordContainsPartOfResult(String word, String result)
//    {
//        for (int i = 1; i < word.length(); i++)
//        {
//            String subWord = word.substring(i, word.length());
//            if (result.startsWith(subWord) || result.contains('#' + subWord))
//            {
//                return subWord;
//            }
//        }
//        return null;
//    }
}