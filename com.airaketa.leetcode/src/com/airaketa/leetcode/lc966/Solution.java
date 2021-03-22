package com.airaketa.leetcode.lc966;

import java.util.*;

/**
 * https://leetcode.com/problems/vowel-spellchecker/
 */
class Solution {
    private static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

    Set<String> words;
    Map<String, String> lowerCaseDictionary = new HashMap<>();
    Map<String, String> maskedVowelsDictionary = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        words = new HashSet<>(Arrays.asList(wordlist));

        for (String word : wordlist) {
            lowerCaseDictionary.putIfAbsent(word.toLowerCase(), word);
            maskedVowelsDictionary.putIfAbsent(maskVowels(word), word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = getCorrectWord(queries[i]);
        }
        return result;
    }

    private String getCorrectWord(String word) {
        if (words.contains(word)) {
            return word;
        }
        String correctWord = lowerCaseDictionary.get(word.toLowerCase());
        if (correctWord != null) {
            return correctWord;
        }
        correctWord = maskedVowelsDictionary.get(maskVowels(word));
        return correctWord == null ? "" : correctWord;
    }

    private String maskVowels(String word) {
        return word.toLowerCase().replaceAll("[aeiou]", "?");
    }
}