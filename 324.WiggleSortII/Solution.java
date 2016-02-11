import java.util.Random;
public class Solution {
    public void wiggleSort(int[] nums) {
      if(nums.length <= 1) {
        return;
      }
      int len = nums.length;
      int median = select(nums, (len - 1)/2);
      int first = 0, mid = 0, last = len - 1;

      printArray(nums);

      //Three Way Partition by Edsger Dijkstra(check Dutch National Flag Problem)
      while(mid <= last) {
        if(nums[vi(len, mid)] > median)  {
          swap(nums, vi(len, first++), vi(len, mid++));
        } else if(nums[vi(len, mid)] < median) {
          swap(nums, vi(len, last--), vi(len, mid));
        } else {
          mid++;
        }
      }
    }
    private int vi(int len, int pos) {
      return (1 + 2 * pos) % (len | 1);
    }
    private int select(int[] arr, int pos) {
      int left = 0, right = arr.length - 1;
      Random rand = new Random();
      while(left <= right) {
        int pivotIndex = partition(arr, left, right, rand.nextInt(right - left + 1) + left);
        if(pivotIndex == pos) return arr[pivotIndex];
        if(pivotIndex < pos) {
          left = pivotIndex + 1;
        } else {
          right = pivotIndex - 1;
        }
      }
      return arr[pos];
    }
    private int partition(int[] arr, int left, int right, int pivotPos) {
      int val = arr[pivotPos];
      swap(arr, right, pivotPos);
      int storeIndex = left;
      for(int i = left; i < right; i++) {
        if(arr[i] < val) {
          swap(arr, i, storeIndex);
          storeIndex++;
        }
      }
      swap(arr, right, storeIndex);

      return storeIndex;
    }
    private void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    public static void main(String[] args) {
      Solution sol = new Solution();
      //int[] nums = {1, 5, 6, 8, 3, 4, 2, 9, 7};
      int[] nums = {3, 5, 5, 6};
      printArray(nums);
      sol.wiggleSort(nums);
      printArray(nums);
    }
    public static void printArray(int[] nums) {
      for(int i = 0; i < nums.length; i++) {
        System.out.print(nums[i]);
        if(i != nums.length - 1) {
          System.out.print(" ");
        } else {
          System.out.println("");
        }
      }
    }
}
