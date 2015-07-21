public class Solution2 {
    public void recoverTree(TreeNode root) {
        //Morris Traversal
        if(root == null) return;
        TreeNode n1 = null, n2 = null, prevNode = root.left == null ? root : null;
        while(root != null) {
            if(root.left == null) {
                if(prevNode != null && prevNode.val > root.val) {
                    if(n1 == null) n1 = prevNode;
                    n2 = root;
                }
                prevNode = root;
                root = root.right;
            } else {
                TreeNode node = root.left;
                while(node.right != null && node.right != root) node = node.right;
                if(node.right == null) {
                    node.right = root;
                    root = root.left;
                } else {
                    if(node.val > root.val) {
                        if(n1 == null) n1 = node;
                        n2 = root;
                    }
                    node.right = null;
                    prevNode = root;
                    root = root.right;
                }
            }
        }
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return;
    }
}
