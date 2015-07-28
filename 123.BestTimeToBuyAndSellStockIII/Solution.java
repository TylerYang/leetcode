public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] profits = new int[prices.length];
        int profit = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if(min > prices[i]) min = prices[i];
            if(max < prices[i]) {
                max = prices[i];
                profit = max - min;
            } else {
                if(prices[i] - min > profit) profit = prices[i] - min;
            }
            profits[i] = profit;
        }
        
        int maxProfit = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        profit = 0;
       
        for(int i = prices.length - 1; i >= 0; i--) {
            if(max < prices[i]) max = prices[i];
            if(min > prices[i]) {
                min = prices[i];
                profit = max - min;
            } else {
                if(max - prices[i] > profit) profit = max - prices[i];
            }
            if(profit + profits[i] > maxProfit) maxProfit = profit + profits[i];
        }
        return maxProfit; 

    }
    
}
