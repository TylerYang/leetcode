public class Solution {
    public int maxProfit(int[] prices) {
        int prevSell = 0, sell = 0, prevBuy, buy = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            prevBuy = buy;
            buy = Math.max(prevSell - prices[i], prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + prices[i], prevSell);
        }
        return sell;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {2, 3, 4, 2, 6, 1, 7};
        System.out.println(sol.maxProfit(prices));
    }
}
