public class Solution{
    public boolean search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while(L < R) {
            int M = (L + R) / 2;
            if(nums[M] == target) return true;
            if(nums[M] < target || L == M) {
                if((target > nums[M] && target <= nums[R]) || L == M) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            } else if(nums[M] > target) {
                if(target > nums[M] && target >= nums[L]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } else {
                R--;
            } 
        }
        return false;
    }
} 

