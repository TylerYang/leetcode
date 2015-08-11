public class Solution {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while(L < R) {
            int M = (L + R) / 2;
            if(nums[M] <= nums[R]) {
                if(nums[M] < nums[R]) {
                    R = M;
                } else {
                    int i = M + 1;
                    while(i < R && nums[i] == nums[M]) i++;
                    if(i == R) {
                        R = M;
                    } else {
                        L = M + 1;    
                    }
                }
            } else {
                L = M + 1;
            }
        }
        return nums[L];
    }
}