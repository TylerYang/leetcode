public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
            
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int M = (L + R) / 2;
            if(nums[M] == target) return M;
            if(nums[M] < nums[R] || L == M) {
                if((target > nums[M] && target <= nums[R]) || L == M) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            } else {
                if(target >= nums[L] && target < nums[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }

            }
        }
        return -1;
    }    
}
