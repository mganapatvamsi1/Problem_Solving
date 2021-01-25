package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;

//First Unique Character in a String
/*
Given a string, find the first non-repeating character in it and return its index.
If it doesn't exist, return -1.
 */
public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!hashMap.containsKey(current)) {
                hashMap.put(current,i);
            } else {
                hashMap.put(current, -1);
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (char c: hashMap.keySet()) {
            if (hashMap.get(c) > -1 && hashMap.get(c) < minValue) {
                minValue = hashMap.get(c);
            }
        }
        int min = (minValue == Integer.MAX_VALUE ? -1 : minValue);
        System.out.println("val: "+ min);
        return min;
//       return minValue == Integer.MAX_VALUE ? -1 : minValue;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        String str1 = "manni"; // 0
        String str2 = "rajaryan"; // 2
        String str3 = "leetcode"; // 0
        String str4 = "ababa"; // -1
        firstUniqueCharacter.firstUniqChar(str1);
        firstUniqueCharacter.firstUniqChar(str2);
        firstUniqueCharacter.firstUniqChar(str3);
        firstUniqueCharacter.firstUniqChar(str4);
    }
}
