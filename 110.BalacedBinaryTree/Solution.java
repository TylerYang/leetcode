public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int r = calBalance(root);
        return r == -1 ? false : true;
    }
    
    private int calBalance(TreeNode root) {
        if(root == null) return 0;
        int leftR = calBalance(root.left);
        if(leftR == -1) return -1;
        int rightR = calBalance(root.right);
        if(rightR == -1) return -1;
        
        if(Math.abs(leftR - rightR) > 1) return -1;
        
        return Math.max(leftR + 1, rightR + 1);
        
    }
}