import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
  public List<Integer> countSmaller(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], 0);
    }

    int count = 1;
    for(Integer key: map.keySet()) {
      map.put(key, count++);
    }
    FenwickTree fenwickTree = new FenwickTree(nums.length);

    List<Integer> list = new ArrayList<Integer>();
    for(int i = nums.length - 1; i >= 0; i--) {
      list.add(0, fenwickTree.sum(map.get(nums[i]) - 1));
      fenwickTree.insert(map.get(nums[i]), 1);
    }
    return list;
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    // int[] nums = {5, 2, 6, 1};
    int[] nums = {-1};
    System.out.println(sol.countSmaller(nums));
  }
}
class FenwickTree {
  int len;
  int[] arr;
  public FenwickTree(int len) {
    this.len = len;
    this.arr = new int[len + 1];
  }
  public int sum(int x) {
    int total = 0;
    while(x > 0) {
      total += arr[x];
      x -= lowbit(x);
    }
    return total;
  }
  public void insert(int x, int diff) {
    while(x <= len) {
      arr[x] += diff;
      x += lowbit(x);
    }
  }
  private int lowbit(int x) {
    return x & -x;
  }
}
