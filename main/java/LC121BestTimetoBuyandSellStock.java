package main.java;

/**
 * Created by joyfeng on 11/21/2016.
 */
public class LC121BestTimetoBuyandSellStock {
    // minprice and maxprofit corresponding to the smallest valley and maximum profit obtained so far respectively
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(prices[i], minprice);
            maxprofit = Math.max(maxprofit, prices[i]-minprice);
        }

        return maxprofit;
    }
}
