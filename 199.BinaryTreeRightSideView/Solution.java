/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rList = new ArrayList<Integer>();
        if(root == null) return rList;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        
        queue.add(root);
        TreeNode spliter = root;
        while(queue.isEmpty() == false) {
            TreeNode curr = queue.poll();
            
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            
            if(curr == spliter) {
                rList.add(curr.val);
                if(queue.isEmpty() == false) {
                    spliter = queue.getLast();
                }
            }
        }
        return rList;
    }
}