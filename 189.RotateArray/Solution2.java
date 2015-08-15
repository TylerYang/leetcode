public class Solution2 {
    public void rotate(int[] nums, int k) {
        //reverse solution
        k %= nums.length;
        if(k <= 0) return;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums);
        
        return;
    }
    private void reverse(int[] nums, int L, int R) {
        while(L < R) {
            int tmp = nums[L];
            nums[L] = nums[R];
            nums[R] = tmp;
            L++;
            R--;
        }
        return;
    }
    private void reverse(int[] nums) {
        reverse(nums, 0, nums.length - 1);
    }
}