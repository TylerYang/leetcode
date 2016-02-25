public class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            insert(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - (sum(i) - sum(i - 1));
        insert(i + 1, diff);
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    public void insert(int x, int diff) {
        while(x < arr.length) {
            arr[x] += diff;
            x += lowbit(x);
        }
    }

    public int sum(int x) {
        x++;
        int total = 0;
        while(x > 0) {
            total += arr[x];
            x -= lowbit(x);
        }
        return total;
    }

    private int lowbit(int x) {
        return x & -x;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(4, 4)); //9
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(4, 4)); //8
    }
}
