public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] mArr1 = new int[nums.length];
        int[] mArr2 = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if(i > 3) {
                mArr1[i] = nums[i] + Math.max(mArr1[i - 2], mArr1[i - 3]);
                mArr2[i] = nums[i] + Math.max(mArr2[i - 2], mArr2[i - 3]);
            } else if(i == 0) {
                mArr1[i] = 0;
                mArr2[i] = nums[i];
            } else if(i == 1) {
                mArr1[i] = nums[i];
                mArr2[i] = nums[i];
            } else if(i == 2) {
                mArr1[i] = nums[i];
                mArr2[i] = nums[i] + mArr2[i - 2];
            } else if(i == 3) {
                mArr1[i] = nums[i] + mArr1[i - 2];
                mArr2[i] = nums[i] + Math.max(mArr2[i - 2], mArr2[i - 3]);
            }
        }
        
        int m1 = Math.max(mArr1[mArr1.length - 1], mArr1[mArr1.length - 2]);
        int m2 = Math.max(mArr2[mArr2.length - 2], mArr2[mArr2.length - 3]);
        
        return Math.max(m1, m2);
    }
}