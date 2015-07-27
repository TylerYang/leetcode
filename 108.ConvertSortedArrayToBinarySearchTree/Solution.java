public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return genBST(nums, 0, nums.length - 1);
    }
    private TreeNode genBST(int[] nums, int L, int R) {
        if(L == R) return new TreeNode(nums[L]);
        int M = (L + R) / 2;
        TreeNode r = new TreeNode(nums[M]);
        if(M > L) r.left = genBST(nums, L, M - 1);
        r.right = genBST(nums, M + 1, R);
        
        return r;
    }
}
