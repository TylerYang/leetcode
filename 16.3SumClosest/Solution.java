import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int r = 0, offset = Integer.MAX_VALUE;     
        for(int i = 0; i < nums.length - 2; i++) {
            while(i > 0 && i < nums.length - 3 && nums[i] == nums[i-1]) i++;
            for(int j = i + 1; j < nums.length - 1; j++) {
                while(j > i + 1 && j < nums.length - 2 && nums[j] == nums[j-1]) j++;
                int n = target - nums[i] - nums[j];
                int k = findClosest(nums, n, j + 1);
                int off = Math.abs(n - nums[k]);
                if(off < offset) {
                    r = nums[i] + nums[j] + nums[k];
                    offset = off;
                }

            }
        }
        return r;
    } 
    private int findClosest(int[] nums, int target, int start) {
        int left = start, right = nums.length - 1;
        while(right - left > 1) {
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(nums[left] - target) < Math.abs(nums[right] - target)? left : right;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(sol.threeSumClosest(nums, 1));
    }
}
