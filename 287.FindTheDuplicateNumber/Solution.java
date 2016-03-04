public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, finder = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        while(true) {
            slow = nums[slow];
            finder = nums[finder];
            if(slow == finder) return finder;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7};
        System.out.println(sol.findDuplicate(nums));
    }
}
