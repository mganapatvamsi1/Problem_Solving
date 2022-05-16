package leetcode.strings;

import java.util.List;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String lcPrefix = "";
        if (strs == null || strs.length == 0) {
            return lcPrefix;
        }
        int index = 0;
        for (char c: strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return lcPrefix;
                }
            }
            lcPrefix += c;
            index++;
        }
        return lcPrefix;
    }


    public static void main(String[] args) {

    }
}
