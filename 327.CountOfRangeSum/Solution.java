import java.util.TreeMap;
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long[] sums = new long[nums.length];

        for(int i = 0; i < nums.length; i++) {
          if(i == 0) {
            sums[i] = nums[i];
          } else {
            sums[i] = sums[i - 1] + nums[i];
          }
          map.put(sums[i], 0);
        }
        map.put(Long.MAX_VALUE, 0);
        map.put(Long.MIN_VALUE, 0);

        int count = 1;
        for(Long key : map.keySet()) {
          map.put(key, count++);
        }

        FenwickTree ft = new FenwickTree(nums.length + 2);
        count = 0;
        long left, right;
        for(int i = 0; i < sums.length; i++) {
          left = map.ceilingKey(sums[i] - upper);
          right = map.floorKey(sums[i] - lower);

          count += ft.sum(map.get(right)) - ft.sum(map.get(left) - 1);
          if(lower <= sums[i] && sums[i] <= upper) {
            count++;
          }
          ft.insert(map.get(sums[i]), 1);
        }
        return count;
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      int[] nums = {-2, 5, -1};
      int lower = -2;
      int upper = 2;
      System.out.println(sol.countRangeSum(nums, lower, upper));

    }
}
class FenwickTree {
  private int len;
  private int[] arr;
  public FenwickTree(int len) {
    this.len = len;
    this.arr = new int[len + 1];
  }
  public void insert(int x, int num) {
    while(x <= len) {
      arr[x] += num;
      x += lowbit(x);
    }
  }
  public int lowbit(int x) {
    return x & -x;
  }
  public int sum(int x) {
    int s = 0;
    while(x > 0) {
      s += arr[x];
      x -= lowbit(x);
    }
    return s;
  }
}
