public class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        //find median element => find kth element in two sorted array
        int n = nums1.length + nums2.length;
        if(n % 2 == 1){
            return findKth(nums1, 0, nums2, 0, n/2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, n/2) + findKth(nums1, 0, nums2, 0, n/2 + 1))/2.0; 
        }
    }
    private int findKth(int[] A, int startA, int[] B, int startB, int k){
        if(startA >= A.length) return B[startB + k - 1];
        if(startB >= B.length) return A[startA + k - 1];
        if(k == 1) return A[startA] < B[startB] ? A[startA] : B[startB];
        
        int currA = startA + k/2 - 1 < A.length ? A[startA + k/2 - 1]:Integer.MAX_VALUE;
        int currB = startB + k/2 - 1 < B.length ? B[startB + k/2 - 1]:Integer.MAX_VALUE;
        
        if(currA < currB){
            return findKth(A, startA + k/2, B, startB, k - k/2);
        } else {
            return findKth(A, startA, B, startB + k/2, k - k/2);
        }
    }
}
