package main.java;

/**
 * Created by joyfeng on 12/26/2016.
 */
public class LC309BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(prices[1] - prices[0], 0);

        for (int i = 2; i < n; i++) {
            int price = prices[i];
            buy[i] = Math.max(sell[i-2] - price, buy[i-1]);  // buy at day i (you can only sell at day i-2) vs buy at day i-1
            sell[i] = Math.max(buy[i-1] + price, sell[i-1]); // sell at day i vs sell at day i-1
        }

        return sell[n-1];
    }
}
