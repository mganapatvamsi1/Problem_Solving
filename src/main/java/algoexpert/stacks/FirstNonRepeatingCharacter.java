package algoexpert.stacks;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public int firstNonRepeatingCharacter(String string) {
        Character character = null;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character c : string.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }

        for (Character c: map.keySet()) {
            if (map.get(c) == 1) {
                character = c;
                break;
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char[] ch = string.toCharArray();
            if (ch[i] == character) return i;
        }
        return -1;
    }

    public Character firstNonRepeatingCharacter2(String string) {
        Character character = null;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (Character c : string.toCharArray()) {
            if (map.containsKey(c)) map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }

        for (Character c: map.keySet()) {
            if (map.get(c) == 1) {
                character = c;
                break;
            }
        }
        return character;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter fnrc = new FirstNonRepeatingCharacter();
//        System.out.println("test: "+fnrc.firstNonRepeatingCharacter2("aabbccdeef"));
        System.out.println("test: "+fnrc.firstNonRepeatingCharacter("ababacc"));
        System.out.println("test: "+fnrc.firstNonRepeatingCharacter2("ababacc"));
//        System.out.println("test: "+fnrc.firstNonRepeatingCharacter("aabbccdeef"));
//        System.out.println("test: "+fnrc.firstNonRepeatingCharacter("ababac"));
    }

}
