public class Solution {
    public void connect(TreeLinkNode root) {
            TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        while (curr != null) {
            TreeLinkNode tmp = curr;
            prev = null;

            while (tmp != null && tmp.left != null) {
                tmp.left.next = tmp.right;
                if (prev != null) {
                    prev.next = tmp.left;
                }
                prev = tmp.right;
                tmp = tmp.next;
            }
            curr = curr.left;
        }
        return;
    }
}
