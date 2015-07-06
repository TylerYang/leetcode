public class Solution {
    public int jump(int[] nums) {
        int count = 0, curr = 0;
        while(curr < nums.length - 1) {
            if(nums[curr] + curr >= nums.length - 1) {
                count++;
                break;
            } else {
                int next = curr;
                for(int i = 1; i <= nums[curr]; i++) {
                    if(nums[curr + i] + curr + i >= nums[next] + next) next = curr + i; 
                }
                curr = next;
                count++;
            }
        }

        return count;
    }
}
