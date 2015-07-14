public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 0, i = -1;
        for(int j = 0; j < nums.length; j++) {
            if(j == 0 || nums[j - 1] == nums[j]) {
                count++;
            } else {
                count = 1;
            }

            if(count <= 2) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
