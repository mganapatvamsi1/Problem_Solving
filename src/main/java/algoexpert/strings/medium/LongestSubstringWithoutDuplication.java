package algoexpert.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int startIndex = 0;
        int[] longest = {0, 1};
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
                startIndex = Math.max(startIndex, lastSeen.get(c) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIndex) {
                longest = new int[] {startIndex, i + 1};
            }
            lastSeen.put(c, i);
        }
        return str.substring(longest[0], longest[1]);
    }

    public static void main(String[] args) {
        System.out.println("longest substring without duplication for this given string \"abacacacaaabacaaaeaaafa\" is: "+longestSubstringWithoutDuplication("abacacacaaabacaaaeaaafa"));
        System.out.println("longest substring without duplication for this given string \"abcadbe\" is: "+longestSubstringWithoutDuplication("abcadbe"));
        System.out.println("longest substring without duplication for this given string \"clementisacap\" is: "+longestSubstringWithoutDuplication("clementisacap"));
    }
}
