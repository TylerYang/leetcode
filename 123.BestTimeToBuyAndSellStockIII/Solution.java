public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];

        int tmp = prices[prices.length - 1], max = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (tmp - prices[i] > max) {
                dp[i] = tmp - prices[i];
                max = dp[i];
            } else {
                dp[i] = max;
            }
            if (prices[i] > tmp) tmp = prices[i];
        }

        tmp = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
            int profit = prices[i] - tmp;

            if (profit + dp[i + 1] > max) {
                max = profit + dp[i + 1];
            }
            if (prices[i] < tmp) tmp = prices[i];
        }
        return max;
    }
}
