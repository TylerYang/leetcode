import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> permutateUnique(int[] nums) {
		List<List<Integer>> rList = new ArrayList<List<Integer>>();
		if(nums.length == 0) return rList;
		Arrays.sort(nums);
		int[] mark = new int[nums.length];
		return permu(nums, mark, nums.length);
    }
	private List<List<Integer>> permu(int[] nums, int[] mark, int level) {
		List<List<Integer>> rList = new ArrayList<List<Integer>>();
		if(level == 0) return rList;
		int prevM = -1;
		for(int i = 0; i < nums.length; i++) {
			if(mark[i] == 0 && (prevM == -1 || nums[i] != nums[prevM])) {
				mark[i] = 1;
				List<List<Integer>> subList = permu(nums, mark, level - 1);
				List<Integer> tmpList = new ArrayList<Integer>();
				if(subList.size() == 0) {
					tmpList.add(nums[i]);
					rList.add(tmpList);
				} else {
					for(int j = 0; j < subList.size(); j++) {
						tmpList = new ArrayList<Integer>();
						tmpList.add(nums[i]);
						tmpList.addAll(subList.get(j));
						rList.add(tmpList);
					}
				}
				mark[i] = 0;
				prevM = i;
			}
		}
		return rList;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {3, 3, 0, 0, 2, 3, 2};
		List<List<Integer>> rList = sol.permutateUnique(nums);
		
		System.out.println(rList.size());
	}
}