public class Solution {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = root.val;     
        maxPathSumHelper(root);
        return max;
    }
    private int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;
        
        int total = root.val;
        int leftVal = maxPathSumHelper(root.left);
        int rightVal = maxPathSumHelper(root.right);

        if(leftVal > 0) total += leftVal;
        if(rightVal > 0) total += rightVal;
        
        if(total > max) max = total;
        
        int maxChild = Math.max(leftVal, rightVal);
        return root.val + (maxChild > 0 ? maxChild : 0);
    }
}
