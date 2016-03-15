import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums.length == 0) return list;
        int pos = 0, i = 1;
        while(i < nums.length) {
            if(nums[i] != nums[i - 1] + 1) {
                if(pos == i - 1) {
                    list.add(Integer.toString(nums[pos]));
                } else {
                    list.add(nums[pos] + "->" + nums[i - 1]);
                }
                pos = i;
            }
            i++;
        }

        if(pos == nums.length - 1) {
            list.add(Integer.toString(nums[pos]));
        } else {
            list.add(nums[pos] + "->" + nums[nums.length - 1]);
        }

        return list;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0,1,2,3,4,5,7};
        System.out.println(sol.summaryRanges(nums));
    }
}
