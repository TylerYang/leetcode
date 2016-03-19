import java.util.HashSet;
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i - k - 1]);

            if(set.contains(nums[i])) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}

