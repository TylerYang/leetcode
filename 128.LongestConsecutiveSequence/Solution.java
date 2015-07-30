public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])) {
                int count = 1;
                int left = nums[i] - 1, right = nums[i] + 1;
                while(numSet.contains(left)) {
                    count++;
                    numSet.remove(left);
                    left--;
                }
                
                while(numSet.contains(right)) {
                    count++;
                    numSet.remove(right);
                    right++;
                }
                if(count > max) max = count;
            }
        }
        return max;
    }
}