import java.util.TreeMap;
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        int max = 0;
        for(int i = 0; i < len; i++) {
            dp[i][len] = 1;
            for(int j = 0; j <= i; j++) {
                if(j == i) {
                    dp[i][j] = 1;
                } else if(nums[i] > nums[j]) {
                    dp[i][j] = dp[j][len] + 1;
                }
                if(dp[i][j] > dp[i][len]) dp[i][len] = dp[i][j];

                if(dp[i][len] > max) max = dp[i][len];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] nums = {1, 7, 2, 8, 3, 4};
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1, 2};
        System.out.println(sol.lengthOfLIS(nums));
    }
}
