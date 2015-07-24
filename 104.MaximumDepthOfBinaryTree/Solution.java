public class Solution {	
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        return Math.max(leftD, rightD);
    }
}
