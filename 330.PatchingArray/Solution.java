public class Solution {
  public int minPatches(int[] nums, int n) {
    int count = 0, i = 0;
    long upperRange = 1;
    while(upperRange <= n) {
      if(i < nums.length && nums[i] <= upperRange) {
        upperRange += nums[i++];
      } else {
        upperRange += upperRange;
        count++;
      }
    }
    return count;
  }
}
