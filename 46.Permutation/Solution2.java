import java.util.List;
import java.util.ArrayList;
public class Solution2 {
    public List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(nums.length == 0) return rList;
        if(nums.length == 1) {
            List<Integer> tmpList = new ArrayList<Integer>();
            tmpList.add(nums[0]);
            rList.add(tmpList);
            return rList;
        }
        int[] mark = new int[nums.length];
        return getPermutation(nums, mark, nums.length);
    }
    private List<List<Integer>> getPermutation(int[] nums, int[] mark, int level) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(level == 0) return rList;
        for(int i = 0; i < nums.length; i++) {
            if(mark[i] == 0) {
                mark[i] = 1;
                List<List<Integer>> subList = getPermutation(nums, mark, level - 1);
                if(subList.size() > 0) {
                    for(int j = 0; j < subList.size(); j++) {
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[i]);
                        tmpList.addAll(subList.get(j));
                        rList.add(tmpList);
                    }
                } else {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(nums[i]);
                    rList.add(tmpList);
                }
            }
        }
        return rList;
    }
}
