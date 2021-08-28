package leetcode.arrays;

/*
 // Best Time to Buy and Sell Stock II
 Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).


 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = {7,6,4,3,1};
        bestTimeToBuyAndSellStock2.maxProfit(arr1);
        bestTimeToBuyAndSellStock2.maxProfit(arr2);
        bestTimeToBuyAndSellStock2.maxProfit(arr3);
    }

}
