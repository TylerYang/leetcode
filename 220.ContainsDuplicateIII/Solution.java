//Given an array of integers,
//find out whether there are two distinct indices
//i and j in the array such that the difference
//between nums[i] and nums[j] is at most t and the
//difference between i and j is at most k.
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        t++;

        for(int i = 0; i < nums.length; i++) {
            if(i > k) map.remove(getID(nums[i - k - 1], t));
            int m = getID(nums[i], t);

            if(map.containsKey(m)) return true;
            if(map.containsKey(m - 1) && Math.abs(map.get(m - 1) - nums[i]) <= t) return true;
            if(map.containsKey(m + 1) && Math.abs(map.get(m + 1) - nums[i]) <= t) return true;

            map.put(m, nums[i]);
        }
        return false;
    }
    private int getID(int num, int t) {
        return num < 0 ? (num + 1) / t - 1 : num / t;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        int t = 5;
        System.out.println(sol.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
