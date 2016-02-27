public class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0) return;
        sums = new int[nums.length + 1];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if(sums == null || sums.length == 0) return 0;
        return sums[j + 1] - sums[i];
    }
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray na = new NumArray(nums);
        System.out.println(na.sumRange(0, 2)); //  1
        System.out.println(na.sumRange(2, 5)); // -1
        System.out.println(na.sumRange(0, 5)); // -3
    }

}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
