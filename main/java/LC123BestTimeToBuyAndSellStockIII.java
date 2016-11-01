package main.java;

/**
 * Created by joyfeng on 10/11/2016.
 */
public class LC123BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // leftt[i]: the max profit before day i
        // righti[]: the max profit after day i
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[] left = new int[length];
        int[] right = new int[length];

        int currMin = prices[0];
        left[0] = 0;
        for (int i = 1; i < length; i++) {
            currMin = Math.min(currMin, prices[i]);
            left[i] = Math.max(prices[i]-currMin, left[i-1]);
        }
        int currMax = prices[length-1];
        right[length-1] = 0;
        for (int i = length-2; i >= 0; i--) {
            currMax = Math.max(currMax, prices[i]);
            right[i] = Math.max(right[i+1], currMax - prices[i]);
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, left[i]+right[i]);
        }

        return result;
    }
}
