import java.util.*;
public class Solution2 {
	//Morris Traversal
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rList = new ArrayList<Integer>();
        while(root != null) {
            if(root.left == null) {
                root = root.right;
                rList.add(root.val);
            } else {
                TreeNode node = root.left;
                while(node.right != null && node.right != root){
                    node = node.right;
                }
                if(node.right == null) {
                    node.right = root;
                    rList.add(root.val);
                    root = root.left;
                } else {
                    node.right = null;
                    root = root.right;
                }
            }
        }
        return rList;
	}
	
}
