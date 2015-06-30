import java.util.Arrays;
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] >= nums[i--]){}

        if(i == 0 && nums[i] > nums[i - 1]) {
            Arrays.sort(nums);
        } else {
            int j = i + 1;
            while(j < nums.length - 1 && nums[j + 1] > nums[i]) j++;
            
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            
            Arrays.sort(nums, i + 1, nums.length);
        }
        return;
    }
}
