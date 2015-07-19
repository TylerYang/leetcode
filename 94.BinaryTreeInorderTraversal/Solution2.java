import java.util.*;
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rlist = new ArrayList<Integer>();
        if(root == null) return rlist;
        
        Stack<TreeNode> tStack = new Stack<TreeNode>(); 
        while(root != null) {
            tStack.push(root);
            root = root.left;     
        }
        
        while(tStack.empty() == false) {
            TreeNode curr = tStack.pop();
            rlist.add(curr.val);
            curr = curr.right;
            while(curr != null) {
                tStack.push(curr);
                curr = curr.right;
            }
        }
        return rlist;
    }
}
