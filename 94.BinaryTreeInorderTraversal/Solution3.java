import java.util.*;
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        //Morris Traversal
        //http://tyleryang.com/2016/04/17/Morris-Traversal-Algorithm/
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode next = curr.left;
                while (next.right != null && next.right != curr) {
                    next = next.right;
                }
                if (next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                } else {
                    next.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}
