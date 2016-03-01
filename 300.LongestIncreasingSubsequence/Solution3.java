import java.util.Arrays;
public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        int maxLen = 0;

        for(int i = 0; i < len; i++) {
            int pos = Arrays.binarySearch(dp, 0, maxLen, nums[i]);
            if(pos < 0) pos = -(pos + 1);
            dp[pos] = nums[i];
            if(pos == maxLen) maxLen++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        // int[] nums = {1, 7, 2, 8, 3, 4};
        // int[] testArr = {1, 2};
        // System.out.println(sol.binarySearch(testArr, 0, 1, 8));
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //int[] nums = {};
        System.out.println(sol.lengthOfLIS(nums));
    }
}
