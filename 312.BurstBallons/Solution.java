public class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for(int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = arr[arr.length - 1] = 1;
        int[][] memo = new int[arr.length][arr.length];
        return burst(arr, memo, 0, arr.length - 1);
    }
    private int burst(int[] arr, int[][] memo, int left, int right) {
        if(memo[left][right] != 0) return memo[left][right];
        int result = 0;
        for(int i = left + 1; i < right; i++) {
           result = Math.max(result, arr[left] * arr[i] * arr[right] + burst(arr, memo, left, i) + burst(arr, memo, i, right));
        }
        memo[left][right] = result;
        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(sol.maxCoins(nums));
    }
}
