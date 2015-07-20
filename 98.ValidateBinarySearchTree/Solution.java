public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> rStack = new Stack<TreeNode>();
        while(root != null) {
            rStack.push(root);
            root = root.left;
        }
        TreeNode prevNode = null;
        while(rStack.empty() == false) {
            TreeNode curr = rStack.pop();
            if(prevNode != null && curr.val < prevNode.val) return false;
            prevNode = curr;
            TreeNode node = curr.right;
            while(node != null) {
                rStack.push(node);
                node = node.left;
            }
        }
        return true;
    }
}
