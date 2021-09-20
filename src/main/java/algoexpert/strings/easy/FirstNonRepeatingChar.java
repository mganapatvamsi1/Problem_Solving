package algoexpert.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
  // Time complexity is O(N) where N is length of the input string.
    // space complexity is O(1) i.e, constant because here the input string only has lowercase english alphabets.
    public int firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> charsMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            charsMap.put(character, charsMap.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (charsMap.get(character) == 1) {
//                System.out.println("test: "+character);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar firstNonRepeatingChar = new FirstNonRepeatingChar();
        System.out.println(firstNonRepeatingChar.firstNonRepeatingCharacter("abcdcaf"));
    }
}
