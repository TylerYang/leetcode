import java.util.*;
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rlist = new ArrayList<Integer>();
        if(root == null) return rlist;
        
        Stack<TreeNode> rStack = new Stack<TreeNode>();
        Set<TreeNode> rSet = new HashSet<TreeNode>();
        while(rStack.empty() == false) {
            TreeNode curr = rStack.peek();
            if(curr.left != null && rSet.contains(curr.left) == false) {
                rStack.push(curr.left);
            } else {
                rStack.pop();
                rlist.add(curr.val);
                rSet.add(curr);
                if(curr.right != null) rStack.push(curr.right);
            }
        }
        return rlist;
    }
}
