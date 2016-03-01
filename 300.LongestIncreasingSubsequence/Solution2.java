import java.util.Arrays;
import java.util.TreeMap;
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int[] order = new int[len];
        Arrays.fill(order, Integer.MIN_VALUE);

        int maxLen = 1;
        order[0] = nums[0];
        for(int i = 1; i < len; i++) {
            int pos = binarySearch(order, 0, maxLen - 1, nums[i]);
            if(pos != Integer.MIN_VALUE) {
                order[pos + 1] = nums[i];
                if(pos + 1 == maxLen) maxLen++;
            }
        }
        return maxLen;
    }
    private int binarySearch(int[] order, int start, int end, int target) {
        int mid = Integer.MIN_VALUE;
        while(start <= end) {
            mid = (start + end) / 2;
            if(order[mid] == target) return Integer.MIN_VALUE;
            if(order[mid] < target) {
                if(mid == end) break;
                if(order[mid + 1] > target) break;
                start = mid + 1;
            } else {
                if(mid == start) {
                    mid = -1;
                    break;
                }
                if(order[mid - 1] < target) {
                    mid--;
                    break;
                }
                end = mid - 1;
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        // int[] nums = {1, 7, 2, 8, 3, 4};
        // int[] testArr = {1, 2};
        // System.out.println(sol.binarySearch(testArr, 0, 1, 8));
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        //int[] nums = {};
        System.out.println(sol.lengthOfLIS(nums));
    }
}
