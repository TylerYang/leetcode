import java.util.*;
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rlist = new ArrayList<List<Integer>>();
        if(root == null) return rlist;
        List<TreeNode> currQ = new LinkedList<TreeNode>();
        List<TreeNode> nextQ = new LinkedList<TreeNode>();
        currQ.add(root);
        List<Integer> slist = new ArrayList<Integer>();
        boolean asc = true;
        while(currQ.size() > 0) {
            TreeNode curr = currQ.remove(currQ.size() - 1);
            if(asc) {
                if(curr.left != null) nextQ.add(curr.left);
                if(curr.right != null) nextQ.add(curr.right);
            } else {
                if(curr.right != null) nextQ.add(curr.right);
                if(curr.left != null) nextQ.add(curr.left);
            }
            slist.add(curr.val);
            if(currQ.size() == 0) {
                rlist.add(slist);
                slist = new ArrayList<Integer>();
                
                currQ = nextQ;
                nextQ = new LinkedList<TreeNode>();
                asc = !asc;
            }  
        }
        
        return rlist;
    }
}
