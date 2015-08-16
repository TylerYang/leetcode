public class Solution {
	public int rob(int[] nums) {
        int[] dp = new int[3];
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
    
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++) {
            int max = dp[(i - 2) % 3];
            if((i - 3) % 3 >= 0 && max < dp[(i - 3) % 3]) max = dp[(i - 3) % 3];
            dp[i % 3] = nums[i] + max;
        }
		return Math.max(dp[(nums.length - 1) % 3], dp[(nums.length - 2) % 3]);
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {2, 3, 2, 2, 9, 2, 3, 10, 7};
		System.out.println(sol.rob(nums));
	}
}