public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int redPos = -1, bluePos = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 2) {
                while(bluePos > 0 && nums[--bluePos] == 2) {}
                if(bluePos == 0 || i >= bluePos) break;
                nums[i] = nums[bluePos];
                nums[bluePos] = nums[i];
            }
            if(nums[i] == 0) {
                if(i == redPos + 1) {
                    redPos++;
                } else {
                    nums[i] = nums[++redPos];
                    nums[redPos] = 0;
                }
            }
        }    
        return;
    }
}
