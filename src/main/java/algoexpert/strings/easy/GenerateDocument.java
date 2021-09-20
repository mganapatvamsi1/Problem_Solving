package algoexpert.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    // Time complexity is O(N + M) where N is the length of characters String, M is length of documents String.
    // Space complexity is O(C) where C is the no of unique characters in the characters String.
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            char character = characters.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < document.length(); i++) {
            char documentChar = document.charAt(i);
            if (!map.containsKey(documentChar) || map.get(documentChar) == 0) return false;
            map.put(documentChar, map.get(documentChar) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        GenerateDocument generateDocument = new GenerateDocument();
        System.out.println(generateDocument.generateDocument("abcabc", "aabbccc")); // false
        System.out.println(generateDocument.generateDocument("abccabc", "aabbccc")); // true
    }
}
