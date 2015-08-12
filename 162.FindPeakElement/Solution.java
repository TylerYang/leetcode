public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length <= 1) return nums.length - 1;
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int M = (L + R) / 2;
            if(M == 0 || nums[M] > nums[M - 1]) {
                if(M == R || nums[M] > nums[M + 1]) {
                    return M;
                } else {
                    L = M + 1;
                }
            } else if(nums[M] < nums[M - 1]){
                R = M - 1;
            }
        }
        return -2;
        //return 
    }
}