import java.util.ArrayDeque;
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //we need peekLast method
        ArrayDeque<TreeNode> tQueue = new ArrayDeque<TreeNode>();
        TreeNode sp = root;
        int depth = 0;
        tQueue.add(root);
        while(tQueue.isEmpty() == false) {
            TreeNode curr = tQueue.poll();
            if(curr.left != null) tQueue.add(curr.left);
            if(curr.right != null) tQueue.add(curr.right);
            if(curr == sp) {
                depth++;
                if(tQueue.isEmpty() == false) sp = tQueue.peekLast();
            }
        }
        return depth;
    }

}
