public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int curr = 0;
        while(curr < nums.length && nums[curr] != 0) {
            int next = curr;
            for(int i = 1; i <= nums[curr]; i++) {
                if(curr + i >= nums.length || nums[curr + i] + curr + i > nums[next] + next) next = curr + i;
            }
        }
        return curr >= nums.length - 1;
    }
}
