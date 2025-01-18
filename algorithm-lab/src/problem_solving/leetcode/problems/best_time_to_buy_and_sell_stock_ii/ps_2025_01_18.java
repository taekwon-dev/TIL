package problem_solving.leetcode.problems.best_time_to_buy_and_sell_stock_ii;

public class ps_2025_01_18 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            maxProfit += prices[i] - minPrice;
            minPrice = prices[i];
        }
        return maxProfit;
    }
}
