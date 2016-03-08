import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rList = new ArrayList<String>();
        if(root == null) return rList;

        List<StringBuffer> ls = new ArrayList<StringBuffer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toString(root.val));
        ls.add(sb);
        stack.push(root);

        while(stack.empty() == false) {
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) {
                StringBuffer tmpSB = ls.get(ls.size() - 1);
                rList.add(tmpSB.toString());
                ls.remove(ls.size() - 1);
            } else {
                TreeNode[] nodes = {node.left, node.right};
                StringBuffer currSB = ls.remove(ls.size() -1);
                for(TreeNode subNode: nodes) {
                    if(subNode != null) {
                        StringBuffer nSB = new StringBuffer();
                        nSB.append(currSB);
                        nSB.append("->");
                        nSB.append(Integer.toString(subNode.val));
                        ls.add(nSB);
                        stack.push(subNode);
                    }
                }
            }
        }
        return rList;
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        System.out.println(sol.binaryTreePaths(n1));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}
