import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rlist = new ArrayList<List<Integer>>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        TreeNode sp = root;

        List<Integer> slist = new ArrayList<Integer>();
        while(queue.isEmpty() == false) {
            TreeNode curr = queue.poll();
            slist.add(curr.val);
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right); 
            if(curr == sp) {
                rlist.add(slist);
                slist = new ArrayList<Integer>();
                sp = queue.getLast();
            }
        }
        return rlist;
    }
}
