import java.util.*;
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        Stack<TreeNode> tStack = new Stack<TreeNode>();
        TreeNode r = new TreeNode(0), node = r;
        int i = 0, j = 0;
        while(true){
            node.left = new TreeNode(preorder[i++]);
            node = node.left;
            tStack.push(node);
            if(preorder[i - 1] == inorder[j]) break;
        }
        
        while(i < preorder.length) {
            if(tStack.empty() || tStack.peek().val == inorder[j]) {
                while(tStack.empty() == false && tStack.peek().val == inorder[j]) {
                    node = tStack.pop();
                    j++;
                }
                node.right = new TreeNode(preorder[i++]);
                node = node.right;
                tStack.push(node);
            } else {
                node = tStack.peek();
                while(true) {
                    node.left = new TreeNode(preorder[i++]);
                    node = node.left;
                    tStack.push(node);
                    if(preorder[i - 1] == inorder[j]) break;
                }
            }
        }

        return r.left;
    }
}
