public class Solution {
  public int coinChange(int[] coins, int amount) {
    if(amount <= 0 || coins == null || coins.length == 0) return 0;
    int[] minNumber = new int[amount + 1];
    for(int i = 1; i <= amount; i++) {
      minNumber[i] = Integer.MAX_VALUE;
      for(int j = 0; j < coins.length; j++) {
        if(coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
          minNumber[i] = Math.min(minNumber[i], 1 + minNumber[i - coins[j]]);
        }
      }
    }
    if(minNumber[amount] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return minNumber[amount];
    }
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] coins = {2, 3, 5};
    int amount = 21;
    System.out.println(sol.coinChange(coins, amount));
  }
}
