public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        
        return sum;
    }
    private void dfs(TreeNode root, int parentValue) {
        int value = parentValue * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += value;
            return;
        }
        
        if(root.left != null) dfs(root.left, value);
        if(root.right != null) dfs(root.right, value);
    }
}