import java.util.Map;
import java.util.HashMap;
public class Solution {
   public int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            if(numsMap.containsKey(val) && numsMap.get(val) != i){
                result[0] = i + 1;
                result[1] = numsMap.get(val) + 1;
                break;
            }
        }
        return result; 
   } 
}
