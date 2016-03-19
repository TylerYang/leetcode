import java.util.*;
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for(int n : nums) {
            queue.offer(n);
        }
        int result = 0;
        for(int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(sol.findKthLargest(nums, k));
    }

}
