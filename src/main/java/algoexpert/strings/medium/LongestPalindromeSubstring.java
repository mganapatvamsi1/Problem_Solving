package algoexpert.strings.medium;

public class LongestPalindromeSubstring {

    //Note: "palindrome" is a string that is written the same forward and backward
    //Note: for an odd letter palindrome the center of the palindrome would be a letter itself but for an even lettered
    //palindrome the center is in-between 2 letters.

    // Trivial solution:
    // to get all possible substrings of the given string and for each substring check if its a palindrome
    // and store the palindromes i.e, the current longest palindrome and replace it with the new palindrome
    // once we find the longer palindrome
    //this option works but when it comes to space-time complexity analysis its not great as it runs in O(Nˆ3) time
    // because to generate all the substrings we've to do double for-loop right i.e, we've to loop through the string
    // first time and again second time to generate the substrings, that is already O(Nˆ2) time just to loop through
    // substrings and for each substring we have to call in some function like isPalindrome or something to check if
    // that particular substring is palindrome or not and that is another O(N) time operation
    // So the overall time complexity is O(N^3) which is not optimal but still works
    public static String longestPalindromeSubstringTrivial(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j);
                if (substring.length() > longest.length()
                        && isPalindrome(substring)) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;
        while (leftIndex < rightIndex) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }


    // Optimal Solution:
    // we can improve the above approach's time complexity by thinking how we can check If a substring
    // of the given string is palindrome or not i.e, in the middle of a string palindrome mirror's itself
    // i.e, if we are in the middle of a palindrome then we can look at the 2 next letters on the either side of it
    // and see if they are equal to each other than that respective part is a palindrome, and we can expand it that way
    // which would still be an O(N) time. i.e, iterate through the input string and at each point in our input string
    // treat the given point as if it's the center of a palindrome, also expand and check if there's any substring that's
    // still a palindrome and if there is then update the currentLongestPalindrome accordingly.
    // by doing this way we can achieve a time complexity of O(Nˆ2)
    // i.e, here we are not checking every substring, but instead we are checking every center of a potential palindrome
    // because a valid palindrome has to have a center somewhere irrespective of if it's an even or off charactered
    // palindrome, so we just check for those center/s and expand from there, and it would end up running in O(Nˆ2) time
    // Space complexity is O(N) because even though we are not storing anything, we still have to slice and store
    // the final substring.
    public static String longestPalindromeSubstringOptimal(String str) {
        // as the default palindrome would always be of length 1
        int[] currentLongest = {0, 1};
        for (int i = 1; i < str.length(); i++) {
            // palindrome with length odd and centered at the current index
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            // palindrome with length even and centered between current and previous letter
            int[] even = getLongestPalindromeFrom(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] getLongestPalindromeFrom(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        return new int[] {leftIndex + 1, rightIndex};
    }




    public static void main(String[] args) {
        System.out.println("longest palindrome out of given str \"abcdefggfedcba\" (trivial) : "+ longestPalindromeSubstringTrivial("abcdefggfedcba"));
        System.out.println("longest palindrome out of given str \"abcdcbe\" (trivial) : "+ longestPalindromeSubstringTrivial("abcdcbe"));
        System.out.println("longest palindrome out of given str \"z234a5abbba54a32z\" (trivial) : "+ longestPalindromeSubstringTrivial("z234a5abbba54a32z"));
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("longest palindrome out of given str \"abcdefggfedcba\" (optimal) : "+ longestPalindromeSubstringOptimal("abcdefggfedcba"));
        System.out.println("longest palindrome out of given str \"ab12365456321bb\" (optimal) : "+ longestPalindromeSubstringOptimal("ab12365456321bb"));
        System.out.println("longest palindrome out of given str \"z234a5abbba54a32z\" (optimal) : "+ longestPalindromeSubstringOptimal("z234a5abbba54a32z"));
        System.out.println("----------------------------------------------------------------------------------------");
    }

}
