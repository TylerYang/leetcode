public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        for(int i = 0; i < nums.length; i++ ){
            int r = nums[i];
            if(r > 0 && r <= nums.length && nums[r - 1] != r) {
                int tmp = nums[r - 1];
                nums[r - 1] = r;
                r = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
