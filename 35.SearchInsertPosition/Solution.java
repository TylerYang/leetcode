public class Solution {
    public int searchInsert(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while(L < R){
            int M = (L + R) / 2;
            if(nums[M] == target) return M;
            if(nums[L] == target) return L;
            if(nums[R] == target) return R;
            
            if(nums[M] < target) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        
        if(L == R) return nums[L] >= target ? L : L + 1;
        if(R < 0) return 0;
        if(L == nums.length) return nums.length;
        
        if(nums[R] > target) {
            return R;
        } else if(nums[L] < target) {
            return L + 1;
        } else {
            return L;
        }
    }
}
