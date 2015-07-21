import java.util.*;
public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        //Morris Traversal
        List<Integer> rlist = new ArrayList<Integer>();
        while(root != null) {
            if(root.left == null){
                rList.add(root.val);
                root = root.right;
            } else {
                TreeNode node = root.left;
                while(node.right != null && node.right != root) node = node;right;
                if(node.right == null) {
                    node.right = root;
                    root = root.left;
                } else {
                    node.right = null;
                    rList.add(root.val);
                    root = root.right;
                }
            }
        }    
        return rList;
    }
}
