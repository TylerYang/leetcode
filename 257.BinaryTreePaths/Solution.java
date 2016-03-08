import java.util.ArrayList;
import java.util.List;
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root == null || (root.left == null && root.right == null)) {
            if(root != null) list.add(Integer.toString(root.val));
            return list;
        }
        List<String> subList;
        TreeNode[] nodes = {root.left, root.right};
        for(TreeNode node : nodes) {
            if(node != null) {
                subList = binaryTreePaths(node);
                StringBuffer sb = new StringBuffer();
                sb.append(root.val);
                sb.append("->");
                int length = sb.length();
                for(int i = 0; i < subList.size(); i++) {
                    sb.append(subList.get(i));
                    list.add(sb.toString());
                    sb.setLength(length);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        System.out.println(sol.binaryTreePaths(n2));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}
