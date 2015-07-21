import java.util.*;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null) return root.right == null;
        if(root.right == null) return false;
        
        TreeNode p = root.left, q = root.right;
        if(p.val != q.val) return false;
        Queue<TreeNode> pQ = new ArrayDeque<TreeNode>();
        Queue<TreeNode> qQ = new ArrayDeque<TreeNode>();
        
        pQ.add(p);
        qQ.add(q);
        
        while(pQ.isEmpty() == false && qQ.isEmpty() == false) {
            p = pQ.poll();
            q = qQ.poll();
			System.out.println("=====");
			System.out.println(p == null);
			System.out.println(q == null);
            if((p.left == null && q.right != null) || (p.left != null && q.right == null) || (p.left != null && q.right != null && p.left.val != q.right.val)) return false;
            if((p.right == null && q.left != null) || (p.right != null && q.left == null) || (p.right != null && q.left != null && p.right.val != q.left.val)) return false;
            if(p.left != null) {
                pQ.add(p.left);
                qQ.add(q.right);
            }
            if(p.right != null) {
                pQ.add(p.right);
                qQ.add(q.left); 
            }
        }
        return pQ.isEmpty() && qQ.isEmpty();
        
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		
		System.out.println(sol.isSymmetric(n1));
	}
}