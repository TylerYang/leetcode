public class Solution {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    int m = nums2.length;
    int[] arr = new int[k];
    for(int i = Math.max(0, k - m); i <= k && i <= n; i++) {
      int[] tmpArr = merge(maxArray2(nums1, i), maxArray2(nums2, k - i));
      if(greater(tmpArr, 0, arr, 0)) {
        arr = tmpArr;
      }
    }
    return arr;
  }
  public int[] maxArray(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[k];
    for (int i = 0, j = 0; i < n; ++i) {
        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
        if (j < k) ans[j++] = nums[i];
    }
    return ans;
  }
  public int[] merge(int[] nums1, int[] nums2) {
    int k = nums1.length + nums2.length;
    int[] arr = new int[k];
    for(int i = 0, j = 0; (i + j) < k;) {
      arr[i + j] = greater(nums1, i, nums2, j) ? nums1[i++]: nums2[j++];
    }
    return arr;
  }
  public boolean greater(int[] nums1, int i, int[] nums2, int j) {
    while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
      i++;
      j++;
    }

    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
  }
  public static void main(String[] args) {
    Solution sol = new Solution();
    // int[] nums1 = {3, 4, 6, 5};
    // int[] nums2 = {9, 1, 2, 5, 8, 3};
    // int k = 5;
    int[] nums1 = {5, 5, 1};
    int[] nums2 = {4, 0, 1};
    int k = 3;
    printArray(sol.maxNumber(nums1, nums2, k));
  }
  public static void printArray(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println("");
  }
}
