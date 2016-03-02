import java.util.Stack;
public class Solution {
    public static void printTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(stack.empty() == false) {
            TreeNode node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);

            System.out.print(node.val + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        printTree(n1);

        System.out.println(codec.serialize(n1));
        TreeNode root = codec.deserialize(codec.serialize(n1));
        printTree(root);
        System.out.println(codec.serialize(root));
    }
}
