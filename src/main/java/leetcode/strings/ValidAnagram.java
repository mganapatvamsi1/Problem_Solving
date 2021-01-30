package leetcode.strings;


public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
//        if (s.equals("") && t.equals("")) return true;
//        for (int i = 0; i < s.length(); i++) {
//            char[] tArr = t.toCharArray();
//            if (s.length() == t.length() &&
//                    new String(tArr).contains(s.substring(i))) return true;
//        }
//        return false;

        if (s.length() != t.length()) return false;
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("", "");

    }

}
