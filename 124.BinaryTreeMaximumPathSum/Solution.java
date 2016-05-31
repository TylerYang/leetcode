public class Solution {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        if (root != null) {
            max = root.val;
        }
        calMaxSum(root);
        return max;
    }
    private int calMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val;
        
        int leftSum = 0;
        if (root.left != null) {
            leftSum = calMaxSum(root.left);
            if (leftSum > 0) result += leftSum;
            
            max = Math.max(leftSum, max);
        }

        int rightSum = 0;
        if (root.right != null) {
            rightSum = calMaxSum(root.right);
            if (rightSum > 0) result += rightSum;
        
            max = Math.max(rightSum, max);
        }
        
        int tmpMax = Math.max(leftSum, rightSum);
    

        max = Math.max(result, max);

        return root.val + (tmpMax > 0 ? tmpMax : 0);
    }
}
