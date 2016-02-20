public class Solution2 {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for(int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = arr[arr.length - 1] = 1;
        int[][] dp = new int[arr.length][arr.length];
        for(int len = 2; len < arr.length; len++) {
            for(int left = 0; left + len < arr.length; left++) {
                int right = left + len;
                int maxVal = 0;
                for(int i = left + 1; i < right; i++) {
                    maxVal = Math.max(maxVal, arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
                }
                dp[left][right] = maxVal;
            }
        }
        return dp[0][arr.length - 1];
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] nums = {3, 1, 5, 8};
        System.out.println(sol.maxCoins(nums));
    }
}
