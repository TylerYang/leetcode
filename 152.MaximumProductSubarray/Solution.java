public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int max_tmp = nums[0];
        int min_tmp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmp = max_tmp;
            max_tmp = max(nums[i], max_tmp * nums[i], min_tmp * nums[i]);
            min_tmp = min(nums[i], tmp * nums[i], min_tmp * nums[i]);
            if(max < max_tmp) max = max_tmp;
        }
        return max;
    }
    private int max(int a, int b, int c) {
        int tmp = a > b ? a : b;
        return tmp > c ? tmp : c;
    }
    private int min(int a, int b, int c) {
        int tmp = a < b ? a : b;
        return tmp < c ? tmp : c;
    }
}