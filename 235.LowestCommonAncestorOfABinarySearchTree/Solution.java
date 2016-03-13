public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node != null){
            boolean leftP = p.val < node.val;
            boolean rightQ = q.val > node.val;

            //One of them is the root node
            //They are in the same side
            if(node == p || node == q || leftP == rightQ) {
                return node;
            } else if(leftP == true) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n2;
        n6.right = n8;

        n2.left = n0;
        n2.right = n4;

        n4.left = n3;
        n4.right = n5;

        n8.left = n7;
        n8.right = n9;

        TreeNode n = sol.lowestCommonAncestor(n6, n5, n0);
        System.out.println(n.val);

        n = sol.lowestCommonAncestor(n6, n4, n2);
        System.out.println(n.val);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
