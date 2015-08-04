public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < nums.length; i++) {
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = twos & ones;
            twos &= ~threes;
            ones &= ~threes;
        }
        return ones;
    }
}