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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Morris Traversal
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        TreeNode curr = dump;
        List<Integer> rList = new ArrayList<Integer>();
        while(curr != null) {
            if(curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode node = curr.left;
                while(node.right != null && node.right != curr) {
                    node = node.right;
                }
                if(node.right == null) {
                    node.right = curr;
                    curr = curr.left;
                } else {
                    addReverse(curr.left, node, rList);
                    node.right = null;
                    curr = curr.right;
                }
            }
        }
        return rList;
    }
    private void addReverse(TreeNode from, TreeNode to, List<Integer> rList) {
        reverse(from, to);
        
        TreeNode node = to;
        while(true) {
            rList.add(node.val);
            if(node == from) break;
            node = node.right;
        }
        
        reverse(to, from);
        return;
    }
    private void reverse(TreeNode from, TreeNode to) {
        if(from == to) return;
        
        TreeNode x = from, y = from.right, z;
        while(true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if(x == to) break;
        }
        
        return;
    }
}