import java.util.Stack;
public class Solution {
    //binary search
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = 0;
        TreeNode node = root;
        while(node != null) {
            height++;
            node = node.left;
        }
        node = root;
        int level = height - 2, count = 0;
        while(level >= 0) {
            TreeNode left = node.left;
            for(int i = 0; i < level; i++) {
                left = left.right;
            }
            if(left != null) {
                node = node.right;
                count += (1 << level);
            } else {
                node = node.left;
            }
            level--;
        }

        if(node) count++;
        return (1 << height - 1) + count - 1;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        System.out.println(sol.countNodes(n1));
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
