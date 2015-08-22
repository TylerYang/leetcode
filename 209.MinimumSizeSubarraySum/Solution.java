public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //linear solution
        if(nums.length == 0) return 0;
        
        int start = 0, end = -1, currSum = 0, minLen = 0;
        while(end < nums.length - 1) {
            while(currSum < s && end < nums.length - 1) {
                currSum += nums[++end];
            }
            while(currSum >= s && start <= end) {
                if(end - start + 1 < minLen || minLen == 0) minLen = end - start + 1;
                currSum -= nums[start++];
            }
        }
        return minLen;
    }
}