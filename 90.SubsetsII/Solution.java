import java.util.*;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        rList.add(new ArrayList<Integer>());
        if(nums.length == 0) return rList;
        Arrays.sort(nums);
        rList.addAll(subWithDup(nums, 0, nums.length - 1));
        return rList;
    }
    private List<List<Integer>> subWithDup(int[] nums, int L, int R) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(L == R) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[L]);
            rList.add(l);
        } else {
            for(int i = L; i <= R; i++) {
                while(i > L && i <= R && nums[i] == nums[i - 1]) i++;
                if(i > R) break;
                List<Integer> l = new ArrayList<Integer>();
                l.add(nums[i]);
                rList.add(l);
                if(i == R) break;
                List<List<Integer>> subList = subWithDup(nums, i + 1, R);
                for(int j = 0; j < subList.size(); j++) {
                    l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.addAll(subList.get(j));
                    rList.add(l);
                }
            }
        }
        return rList;
    }
}
