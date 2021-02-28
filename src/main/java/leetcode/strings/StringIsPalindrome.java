package leetcode.strings;


import java.util.Stack;

public class StringIsPalindrome {


    public boolean isPalindrome(String s) {

        //TODO: Solution-1
//        int start = 0;
//        int end = s.length() - 1;
//        while (start < end) {
//            while (start < end &&
//                  !Character.isLetterOrDigit(s.charAt(start)) ) start++;
//            while (start < end &&
//                   !Character.isLetterOrDigit(s.charAt(end))) end--;
//            if (start < end &&
//                Character.isLowerCase(s.charAt(start++)) != Character.isLowerCase(s.charAt(end--)) ) return false;
//        }
//        return true;

        //TODO: Solution-2
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Character ch: s.toCharArray()) {
//            if (Character.isLetterOrDigit(ch)) {
//                stringBuilder.append(Character.toLowerCase(ch));
//            }
//        }
//        String filteredStr = stringBuilder.toString();
//        String reversedStr = stringBuilder.reverse().toString();
//        return filteredStr.equals(reversedStr);

        //TODO: Solution-3 (solution for java-8 streams)
        StringBuilder builder = new StringBuilder();
        s.chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(builder::append);
        return builder.toString().equals(builder.reverse().toString());

    }


    public static void main(String[] args) {

    }

}
