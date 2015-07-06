import java.util.List;
import java.util.ArrayList;
public class Solution3 {
    public List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(nums.length == 0) return rList;
        List<Integer> tmpList = new ArrayList<Integer>();
        tmpList.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            List<List<Integer>> crList = rList;
            rList = new ArrayList<List<Integer>>();
            for(int j = 0; j < crList.size(); j++) {
                List<Integer> pList = crList.get(j);
                for(int k = 0; k < pList.size() + 1; k++) {
                    List<Integer> npList = new ArrayList<Integer>(pList);
                    npList.add(k, nums[i]);
                    rList.add(npList);
                } 
            }
        }
        return rList;
    }
}
