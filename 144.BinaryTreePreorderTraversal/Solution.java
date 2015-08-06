/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rList = new ArrayList<Integer>();
        if(root == null) return rList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(stack.empty() == false) {
            TreeNode currNode = stack.pop();
            rList.add(currNode.val);
            if(currNode.right != null) stack.push(currNode.right);
            if(currNode.left != null) stack.push(currNode.left);
        }
        return rList;
    }
}