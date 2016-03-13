import java.util.Stack;
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        int i = 0;
        while(i != k && stack.empty() == false) {
            node = stack.pop();
            if(node.right != null) {
                TreeNode tmpNode = node.right;
                while(tmpNode != null) {
                    stack.push(tmpNode);
                    tmpNode = tmpNode.left;
                }
            }
            i++;
        }
        return node.val;
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

        int n = sol.kthSmallest(n6, 3);
        System.out.println(n);

        n = sol.kthSmallest(n6, 8);
        System.out.println(n);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
