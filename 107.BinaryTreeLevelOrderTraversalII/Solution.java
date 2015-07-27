import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> rlist = new ArrayList<List<Integer>>();
       if(root == null) return rlist;
       ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
       nodeQueue.add(root);
       TreeNode sp = root;
    
       List<Integer> currlist = new ArrayList<Integer>();
       while(nodeQueue.isEmpty() == false) {
           TreeNode curr = nodeQueue.poll();
           currlist.add(curr.val);
        
           if(curr.left != null) nodeQueue.add(curr.left);
           if(curr.right != null) nodeQueue.add(curr.right);
        
           if(curr == sp) {
               rlist.add(0, currlist);
               currlist = new ArrayList<Integer>();
               if(nodeQueue.isEmpty() == false) sp = nodeQueue.peekLast();
           }
       }
    
       return rlist;
   }
}
