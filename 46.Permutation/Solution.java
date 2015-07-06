import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<List<Integer>> permutate(int[] nums) {
        List<Integer> numsList = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) numsList.add(nums[i]);
        return getPermutation(numsList);
    }
    public List<List<Integer>> getPermutation(List<Integer> numsList) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(numsList.size() == 0) return rList;
        if(numsList.size() == 1) {
            rList.add(numsList);
            return rList;
        } 
        for(int i = 0; i < numsList.size(); i++) {
            List<Integer> tmpList = new ArrayList<Integer>(numsList);
            int e = tmpList.remove(i);
            List<List<Integer>> subList = getPermutation(tmpList);
            for(int j = 0; j < subList.size(); j++) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(e);
                l.addAll(subList.get(j));
                rList.add(l);
            }
        }
        return rList;
    }
}
