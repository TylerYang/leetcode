public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            if(prices[i] > max) {
                max = prices[i];
                if(profit < max - min) profit = max - min;
            } else {
                if(prices[i] - min > profit) profit = prices[i] - min;
            }
        }
        return profit;
    }
}
