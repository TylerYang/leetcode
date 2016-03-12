import java.util.Queue;
import java.util.ArrayDeque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int[] arr = new int[nums.length - k + 1];
        int i = 0;
        while(i < nums.length) {
            if(deque.size() > 0 && i - deque.getFirst() >= k) deque.removeFirst();
            int val = nums[i];
            while(deque.size() > 0 && nums[deque.getLast()] < val) {
                deque.removeLast();
            }
            deque.add(i);
            if(i >= k - 1) {
                arr[i - k + 1]= nums[deque.getFirst()];
            }
            i++;
        }
        return arr;
    }
    public static void printArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {};
        Solution sol = new Solution();
        printArray(sol.maxSlidingWindow(nums, 0));
    }
}
