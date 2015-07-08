public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        return maxSubArr(nums, 0, nums.length - 1);
    }
    private int maxSubArr(int[] nums, int L, int R) {
        if(L == R) return nums[L];
        int M = (L + R) / 2;
        int lMax = maxSubArr(nums, L, M);
        int rMax = maxSubArr(nums, M + 1, R);
        
        int r = 0, tmpLMax = nums[M], tmpRMax = nums[M + 1], sum = 0;
        
        for(int i = M; i >= L; i--) {
            sum += nums[i];
            if(sum > tmpLMax) tmpLMax = sum;
        }
        
        sum = 0;
        for(int i = M + 1; i <= R; i++) {
            sum += nums[i];
            if(sum > tmpRMax) tmpRMax = sum;
        }
        
        r = tmpLMax + tmpRMax;
        
        return max(r, lMax, rMax);
    }
    private int max(int a, int b, int c) {
        int r = a > b ? a : b;
        return r > c ? r : c;
    }
}
