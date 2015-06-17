import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if(nums.length < 3) return rList;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            while(i > 0 && i < nums.length - 1 && nums[i] == nums[i - 1]) i++;
            for(int j = i + 1; j < nums.length - 1; j++) {
                while(j > i + 1 && j < nums.length - 1&& nums[j] == nums[j -1]) j++;
                int target = 0 - nums[i] - nums[j];
                int k = Arrays.binarySearch(nums, j, nums.length, target);
                if(k > j){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    rList.add(list);
                }
            } 
        }

        return rList;
    }
}


