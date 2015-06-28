public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int pos = 0, i = 1;
        while(i < nums.length) {
            if(nums[i] != nums[pos]) nums[++pos] = nums[i];
            i++;
        }
        return pos + 1;
    }
}
