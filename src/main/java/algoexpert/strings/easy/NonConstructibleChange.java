package algoexpert.strings.easy;

import java.util.Arrays;

public class NonConstructibleChange {

    public int nonConstructibleChange(int[] coins) {
        if (coins.length == 0) return 1;
        Arrays.sort(coins); // this line takes O(NlogN) time complexity.

        int count = 1;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > count) {
                return count;
            }
            count += coins[i];
        }
        return count;
    }

    public static void main(String[] args) {
        NonConstructibleChange nonConstructibleChange = new NonConstructibleChange();
        int[] testArr = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange.nonConstructibleChange(testArr)); // 20
    }
}
