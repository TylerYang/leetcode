public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> dfs = new Stack<TreeNode>();
        dfs.push(root);
        TreeNode node = root;
        while(dfs.empty() == false) {
            TreeNode curr = dfs.pop();
            if(curr.right != null) {
                dfs.push(curr.right);
                curr.right = null;
            }
            if(curr.left != null) {
                dfs.push(curr.left);
                curr.left = null;
            }
            if(dfs.empty() == false)
                node.right = dfs.peek();
            node = node.right;
        }
        return;
    }
}