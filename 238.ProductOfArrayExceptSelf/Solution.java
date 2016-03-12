public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int[] arr = new int[nums.length];
        arr[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            arr[i] = nums[i - 1] * arr[i - 1];
        }
        
        int prod = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i] * prod;
            prod *= nums[i];
        }
        return arr;
    }
}
