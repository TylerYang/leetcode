import java.util.Arrays;
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 1;
        while(i > 0 && nums[i - 1] >= nums[i--]){}

        if(i == 0 && nums[i] > nums[i - 1]) {
            reverseBetween(nums, 0, nums.length - 1);
        } else {
            int j = i + 1;
            while(j < nums.length - 1 && nums[j + 1] > nums[i]) j++;
            
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            
            reverseBetween(nums, i + 1, nums.length - 1);
        }
        return;
    }
    private void reverseBetween(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            
            left++;
            right--;
        }
        
    }
}
