public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int level = 1;
        TreeNode sp = root;
        queue.add(root);
        while(queue.isEmpty() == false) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) {
                return level;
            }
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            
            if(curr == sp) {
                level++;
                if(queue.isEmpty() == false) sp = queue.peekLast();
            }
        }
        return level;
    }
}