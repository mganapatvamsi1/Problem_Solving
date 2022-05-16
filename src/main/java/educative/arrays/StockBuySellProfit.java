package educative.arrays;

/*
////ALGORITHM:
current profit = INT_MIN
current buy = stock_prices[0]
global sell = stock_prices[1]
global profit = global sell - current buy

for i = 1 to stock_prices.length:
  current profit = stock_prices[i] - current buy
  if current profit is greater than global profit
    then update global profit to current profit and update global sell to stock_prices[i]
  if stock_prices[i] is less than current buy
    then update current buy to stock_prices[i]

return global profit and global sell
 */

public class StockBuySellProfit {


    public static Tuple findBuySellStockPrices(int[] array) {
        if (array == null || array.length < 2) return null;

        int current_profit = Integer.MIN_VALUE;
        int current_buy = array[0];
        int global_sell = array[1];
        int global_profit = global_sell - current_buy;

        for (int i = 1; i < array.length; i++) {
            current_profit = array[i] - current_buy;

            if (current_profit > global_profit) {
                global_profit = current_profit;
                global_sell = array[i];
            }

            if (array[i] < current_buy) current_buy = array[i];
        }
        // note: global_sell - global_profit gives buy price
        return new Tuple<>(global_sell - global_profit, global_sell);
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPrices(array2);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

    }
}
