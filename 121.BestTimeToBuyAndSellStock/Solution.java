public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return profit;
    }
}
