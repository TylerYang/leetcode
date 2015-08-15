public class Solution {
	public void rotate(int[] nums, int k) {
        //swap solution
        if(k == 0) return;
        k %= nums.length;
		
        int tmp = 0, curr = -1, count = 0;
		for(int i = -1; i < k;) {
			if(count == nums.length) break;
			int next;
			if(curr == i) {

				i++;
				curr++;
				
				next = (curr + k) % nums.length;
				
				tmp = nums[next];
				nums[next] = nums[curr];
				
				curr = next;
			} else {
				next = (curr + k) % nums.length;
				
				int nextTmp = nums[next];
				nums[next] = tmp;
				tmp = nextTmp;

			}
			count++;

			curr = next;
		}
        return;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		
		sol.rotate(nums, 4);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("");
	}
}