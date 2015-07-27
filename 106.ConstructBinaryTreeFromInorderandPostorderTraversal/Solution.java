import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inEnd == inStart) return new TreeNode(inStart);

        TreeNode r = new TreeNode(post[postEnd]);
        
        int idx = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if(in[i] == post[postEnd]) {
                idx = i;
                break;
            }
        }

        if(idx != inStart) r.left = buildTree(in, inStart, idx - 1, post, postStart, postStart + idx - inStart - 1);
        if(idx != inEnd) r.right = buildTree(in, idx + 1, inEnd, post, postEnd - inEnd + idx, postEnd - 1);

        return r;
    }
}
