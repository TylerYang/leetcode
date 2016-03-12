public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == q) return p;

        Boolean isLeftP = isChildren(root.left, p);
        Boolean isRightQ = isChildren(root.right, q);

        if(isLeftP == isRightQ){
            return root;
        } else if(isLeftP == true) {
            if(root == q) return root;
            return lowestCommonAncestor(root.left, p, q);
        } else {
            if(root == p) return root;
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    private boolean isChildren(TreeNode root, TreeNode node) {
        if(root == null) return false;
        if(root == node) return true;
        return isChildren(root.left, node) || isChildren(root.right, node);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;

        n2.left = n7;
        n2.right = n4;

        n1.left = n0;
        n1.right = n8;

        TreeNode n = sol.lowestCommonAncestor(n3, n5, n4);
        System.out.println(n.val);

        n = sol.lowestCommonAncestor(n3, n6, n4);
        System.out.println(n.val);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
