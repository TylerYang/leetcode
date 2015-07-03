import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return comSum(candidates, target, 0);
    }
    private List<List<Integer>> comSum(int[] candidates, int target, int L) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(target < candidates[0]) return rList;
        
        for(int i = L; i < candidates.length && target <= candidates[i]; i++) {
            int n = candidates[i];
            if(n == target) {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(target);
                rList.add(tmpList);
                break;
            } else {
                List<List<Integer>> subList = comSum(candidates, target - n, i);
                for(int j = 0; j < subList.size(); j++) {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(n);
                    tmpList.addAll(subList.get(j));
                    rList.add(tmpList);
                }
            }
        }
        return rList;
    }
}
