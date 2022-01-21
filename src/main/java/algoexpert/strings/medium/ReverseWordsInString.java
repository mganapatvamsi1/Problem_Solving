package algoexpert.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {

    public static String reverseWordsInString(String string) {
        ArrayList<String> wordsList = new ArrayList<String>();
        int startOfWord = 0;
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (character == ' ') {
                wordsList.add(string.substring(startOfWord, index));
                startOfWord = index;
            } else if (string.charAt(startOfWord) == ' ') {
                wordsList.add(" ");
                startOfWord = index;
            }
        }
        wordsList.add(string.substring(startOfWord));

        Collections.reverse(wordsList);
//        System.out.println("actual: "+wordsList);
        //TODO: this implementation is not working for all cases, need to get back on this later
//        reverseList(wordsList, 0, wordsList.size() - 1);

//        System.out.println("reversed: "+wordsList);
        return String.join("", wordsList);
    }

    public static void reverseList(List<?> list, int start, int end) {
        final List givenList = list;
        givenList.set(start, givenList.set(end, givenList.get(start)));

    }

    // this would only work for List<Integer>
    public static void swap(List<Integer> list, int start, int end) {
        int temp = list.get(end);
        list.set(end, list.get(start));
        list.set(start, temp);
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));  // "toMove": 2
        List<Integer> test2 = Arrays.asList(1, 2, 4, 5, 6); //  "toMove": 3
//        List<String> test1 = new ArrayList<>();
//        test1.add("He");
//        test1.add(" ");
//        test1.add("is");
//        test1.add(" ");
//        test1.add("good");
//        swap(test1, 0, test1.size() - 1);

        System.out.println("reverse words in str: "+reverseWordsInString("He is good"));

        System.out.println("reverse words in str2: "+reverseWordsInString("she has always been great"));
    }
}
