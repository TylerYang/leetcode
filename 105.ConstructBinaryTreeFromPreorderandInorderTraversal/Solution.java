import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootVal = preorder[0];
        int idx = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, idx);
        int[] rightPre = Arrays.copyOfRange(preorder, idx, preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightIn = Arrays.copyOfRange(inorder, idx, inorder.length);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }
}
