public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] r = {-1, -1}; 
        if(nums.length == 0) return r;
        r[0] = getLeftRange(nums, target, 0, nums.length - 1);
        if(r[0] == -1) return r;
        r[1] = getRightRange(nums, target, r[0], nums.length - 1);
        
        return r;
    }
    private int getLeftRange(int[] nums, int target, int L, int R) {
        while(L < R) {
            int M = (L + R) / 2;
            if(nums[M] < target) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        int pos = nums[L] == target ? L : L - 1;
        return pos > 0 && nums[pos] == target ? pos : -1; 
    }
    private int getRightRange(int[] nums, int target, int L, int R) {
        while(L < R) {
            int M = (L + R) / 2;
            if(nums[M] <= target) {
                L = M + 1;
            } else {
                R = M;
            }    
        }
        int pos = nums[L] == target ? L : L - 1;
        return pos > 0 && nums[pos] == target ? pos : -1; 
    }
}

