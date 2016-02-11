public class Test {
  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 1, 2, 0};
    printArray(nums);
    sortColors(nums);
    printArray(nums);
  }
  public static void sortColors(int[] nums) {
    int first = 0, mid = 0, last = nums.length - 1;
    while(mid <= last) {
      if(nums[mid] < 1) {
        swap(nums, first++, mid++);
      } else if(nums[mid] > 1) {
        swap(nums, mid, last--);
      } else {
        mid++;
      }
    }
  }
  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
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
