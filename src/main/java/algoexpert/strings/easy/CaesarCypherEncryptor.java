package algoexpert.strings.easy;

public class CaesarCypherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (key > 26) key -= 26;
            char character =  (char) (str.charAt(i) + key);
            if (character > 'z') {
                newStr += (char) (str.charAt(i) - (26 - key));
            } else {
                newStr += (char) (str.charAt(i) + key);
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        CaesarCypherEncryptor ccEncryptor = new CaesarCypherEncryptor();
        System.out.println(caesarCypherEncryptor("xyz", 2)); // "zab"
        System.out.println(caesarCypherEncryptor("abc", 52)); // "abc"
    }
}
