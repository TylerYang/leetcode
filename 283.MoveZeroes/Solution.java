public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            } else {
                zeroCount++;
            }
        }
        int i = nums.length - 1;
        while(zeroCount > 0) {
            nums[i--] = 0;
            zeroCount--;
        }
    }
    public static void printArray(int[] nums) {
        for(int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        printArray(nums);
        sol.moveZeroes(nums);
        printArray(nums);
    }
}
