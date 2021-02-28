package leetcode.stacks;

import java.util.HashSet;

/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 */
public class RemoveAdjDuplicates1 {

    public String removeDuplicates(String S) {
        //Method-1 (using strings)
//        HashSet<String> set = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        for (char i = 'a'; i <= 'z'; i++) {
//            sb.setLength(0);
//            sb.append(i);
//            sb.append(i);
//            set.add(sb.toString());
//        }
//        int prevLength = -1;
//        while (prevLength != S.length()) {
//            prevLength = S.length();
//            for (String d : set) {
//                S = S.replace(d, "");
//            }
//        }
//        return S;

        // Method-2 (Using stacks)
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : S.toCharArray()) {
            if (sbLength != 0 && c == S.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }

}
