public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode firstNode = null, secondNode = null;
        TreeNode curr = root;

        //preorder morris traversal
        TreeNode prevNode = null;

        while (curr != null) {
            if (curr.left == null) {
                if (prevNode != null && prevNode.val > curr.val) {
                    if (firstNode == null) {
                        firstNode = prevNode;
                    }
                    secondNode = curr;
                }
                prevNode = curr;
                curr = curr.right;
            } else {
                TreeNode nextNode = curr.left;
                while (nextNode.right != null && nextNode.right != curr) {
                    nextNode = nextNode.right;
                }
                if (nextNode.right == null) {
                    nextNode.right = curr;
                    curr = curr.left;
                } else {
                    nextNode.right = null;
                    if (prevNode != null && prevNode.val > curr.val) {
                        if (firstNode == null) {
                            firstNode = prevNode;
                        }
                        secondNode = curr;
                    }
                    prevNode = curr;
                    curr = curr.right;
                }
            }
        }
        if (firstNode != null) {
            swapValue(firstNode, secondNode);
        }
    }
    private void swapValue(TreeNode n1, TreeNode n2) {
        int val = n1.val;
        n1.val = n2.val;
        n2.val = val;
    }
}
