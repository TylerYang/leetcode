import java.util.*;
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(q == null || p.val != q.val) return false;
        
        Queue<TreeNode> pQueue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> qQueue = new ArrayDeque<TreeNode>();
        pQueue.add(p);
        qQueue.add(q);
        while(pQueue.isEmpty() == false && qQueue.isEmpty() == false) {
            TreeNode n1 = pQueue.poll();
            TreeNode n2 = qQueue.poll();
            
            
            if((n1.left == null && n2.left != null) || (n1.left != null && n2.left == null) || (n1.left != null && n2.left != null && n1.left.val != n2.left.val)) return false;
            if((n1.right == null && n2.right != null) || (n1.right != null && n2.right == null) || (n1.right != null && n2.right != null && n1.right.val != n2.right.val)) return false;
            
            
            if(n1.left != null) {
                pQueue.add(n1.left);
                qQueue.add(n2.left);
            }
            
            if(n1.right != null) {
                pQueue.add(n1.right);
                qQueue.add(n2.right);
            }
        }
        
        return pQueue.isEmpty() && qQueue.isEmpty();
        
    }
}