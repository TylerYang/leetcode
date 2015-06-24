import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(nums.length < 4)  return rList;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            while(i > 0 && i < nums.length -3 && nums[i] == nums[i - 1]) i++;
            for(int j = i + 1; j < nums.length - 2; j++){
                while(j > i + 1 && j < nums.length - 2 && nums[j] == nums[j-1]) j++;
                for(int  k = j + 1; k < nums.length - 1; k++){
                    while(k > j + 1 && k < nums.length - 1 && nums[k] == nums[k-1]) k++;
                    int n = target - nums[i] - nums[j] - nums[k];
                    int l = Arrays.binarySearch(nums, k + 1, nums.length, n);
                    if(l > k){
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
