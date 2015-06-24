import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SolutionHM {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(nums.length < 4)  return rList;
        Arrays.sort(nums);
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length - 3; i++){
            while(i > 0 && i < nums.length -3 && nums[i] == nums[i - 1]) i++;
            for(int j = i + 1; j < nums.length - 2; j++){
                while(j > i + 1 && j < nums.length - 2 && nums[j] == nums[j-1]) j++;
                for(int  k = j + 1; k < nums.length - 1; k++){
                    while(k > j + 1 && k < nums.length - 1 && nums[k] == nums[k-1]) k++;
                    int n = target - nums[i] - nums[j] - nums[k];
                    
                    if(numsMap.containsKey(n) && numsMap.get(n) > k){
                        int l = numsMap.get(n);
                        List<Integer> currList = new ArrayList<Integer>();
                        currList.add(nums[i]);
                        currList.add(nums[j]);
                        currList.add(nums[k]);
                        currList.add(nums[l]);
                        rList.add(currList);
                    }
                }
            }
        }
        return rList;
    }    
}
