public class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, len = nums.length;
        
        while(i < nums.length) {
            if(nums[i] == i || nums[i] == len) {
                i++;
            } else{
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j]) return j;
        }
        return nums.length;
    }
}
