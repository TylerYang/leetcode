public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int max = 0, left = 0, right = height.length - 1;
        while(left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, currHeight * width);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,2,4,6,7,8,4,4,5};
        System.out.println(sol.maxArea(height));
    }
}
