package leetcode.strings;

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":
Given a positive integer n, return the nth term of the count-and-say sequence.
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";

        while (n > 1) {
            // as sb is a mutable type, its suggested that sb is more efficient when we try
            // to append to a sb, however if i try to do the same thing for  a string a new
            // object will be created every iteration.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                // Here i have to go to previous element and count how many times that previous element appeared
                int count = 1;
                while ( i+1 < result.length() && result.charAt(i) == result.charAt(i + 1) ) {
                    count++;
                    i++;
                }
                sb.append(count).append(result.charAt(i));
            }
            result = sb.toString();
            //TODO: here this while loop will execute (N - 1) times.
            n--;
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
