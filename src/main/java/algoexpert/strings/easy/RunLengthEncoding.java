package algoexpert.strings.easy;

public class RunLengthEncoding {
// Time complexity is O(N) and space complexity is O(N)
// where N is the length of the input string.
    public String runLengthEncoding(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (c1 != c2 || count == 9) {
                stringBuilder.append(Integer.toString(count));
                stringBuilder.append(c1);
                count = 0;
            }
            count += 1;
        }
        // handle last run
        stringBuilder.append(Integer.toString(count));
        stringBuilder.append(str.charAt(str.length() - 1));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();

    }
}
