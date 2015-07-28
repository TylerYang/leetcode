public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode p = root;
        TreeLinkNode first = null;
        while(p) {
            if(first == null) {
                first = p.left;
            }
            if(p.left != null) {
                p.left.next = p.right;
            }
            if(p.right != null && p.next != null) {
                p.right.next = p.next.left;
            }
            if(p.next == null) {
                p = first;
                first = null;
            } else {
                p = p.next;
            }
        }
        return;

    }
}
