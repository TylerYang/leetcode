public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int local = nums[0];
        for(int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            if(max < local) max = local;
        }
        return max;
    }
}