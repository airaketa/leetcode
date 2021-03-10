package com.airaketa.leetcode.lc16;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
class Solution {
    private RomanIntPair[] dictionary = {
            new RomanIntPair('I', 1, 'V', 5),
            new RomanIntPair('X', 10, 'L', 50),
            new RomanIntPair('C', 100, 'D', 500),
            new RomanIntPair('M', 1000)
    };

    public String intToRoman(int num) {
        String result = "";
        int startIndex = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (num >= dictionary[i].number) {
                startIndex = i;
            }
            else {
                break;
            }
        }

        for (int i = startIndex; i >= 0; i --) {
            RomanIntPair pair = dictionary[i];
            int div = num / pair.number;
            if (div < 4) {
                for (int j = 0; j < div; j++) {
                    result += pair.character;
                }
            }
            else if (div < 5) {
                result += pair.character;
                result += pair.fifthCharacter;
            }
            else if (div < 9) {
                result += pair.fifthCharacter;
                for (int j = 0; j < div - 5; j++) {
                    result += pair.character;
                }
            }
            else {
                result += pair.character;
                result += dictionary[i + 1].character;
            }

            num = num % pair.number;
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(new Solution().intToRoman(10));
    }

    public class RomanIntPair
    {
        private char character;
        private int number;
        private char fifthCharacter;
        private int fifthNumber;

        RomanIntPair(char character, int number, char fifthCharacter, int fifthNumber)
        {
            this.character = character;
            this.number = number;
            this.fifthCharacter = fifthCharacter;
            this.fifthNumber = fifthNumber;
        }

        RomanIntPair(char character, int number)
        {
            this.character = character;
            this.number = number;
        }
    }
}