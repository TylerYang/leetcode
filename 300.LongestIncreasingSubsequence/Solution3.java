public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] ends = new int[nums.length];
        ends[0] = nums[0];
        int len = 1;

        for (int n: nums) {
            int pos = binarySearch(ends, 0, len - 1, n);
            //duplicated element
            if (pos < 0) {
                pos = -pos;
            }

            ends[pos] = n;
            len = Math.max(len, pos + 1);
        }
        return len;
    }
    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -left;
    }
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        // int[] nums = {1, 7, 2, 8, 3, 4};
        // int[] testArr = {1, 2};
        // System.out.println(sol.binarySearch(testArr, 0, 1, 8));
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //int[] nums = {};
        System.out.println(sol.lengthOfLIS(nums));
    }
}
