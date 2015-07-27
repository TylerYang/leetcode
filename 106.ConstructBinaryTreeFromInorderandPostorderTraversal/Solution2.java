import java.util.*;
public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        Stack<TreeNode> tStack = new Stack<TreeNode>();
        TreeNode r = new TreeNode(0), node = r;
        int i = postorder.length - 1, j = inorder.length - 1;
        while(true) {
            node.right = new TreeNode(postorder[i--]);
            node = node.right;
            tStack.push(node);
            if(postorder[i + 1] == inorder[j]) break; 
        }
        while(i > -1) {
            if(tStack.empty() || tStack.peek().val == inorder[j]) {
                while(tStack.empty() == false && tStack.peek().val == inorder[j]) {
                    node = tStack.pop();
                    j--;
                }
                node.left = new TreeNode(postorder[i--]);
                node = node.left;
                tStack.push(node);
            } else {
                node = tStack.peek();
                while(true) {
                    node.right = new TreeNode(postorder[i--]);
                    node = node.right;
                    tStack.push(node);
                    if(postorder[i + 1] == inorder[j]) break;
                }
            }
        }
        return r.right;
    }
    
}
