public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0) return;
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(j > -1) {
            if(i < 0) {
                while(j > -1) nums1[k--] = nums2[j--];
            } else {
                if(nums1[i] > nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            } 
        }
        return;
    }
}
