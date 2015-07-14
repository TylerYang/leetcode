import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int total = (int) Math.pow(2, nums.length);
        for(int i = 0; i < total; i++) {
            List<Integer> iList = new ArrayList<Integer>();
            int b = 1;
            for(int j = 0; j < nums.length; j++) {
                if((i & b) > 0) {
                    iList.add(nums[j]);
                }
                b <<= 1;
            }
            rList.add(iList);
        } 
        return rList;
    }
}
