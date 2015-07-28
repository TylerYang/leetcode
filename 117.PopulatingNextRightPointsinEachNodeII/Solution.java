public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode p = root;
        TreeLinkNode last = null;
        TreeLinkNode first = null;
        while(p != null) {
            if(first == null) {
                if(p.left != null) {
                    first = p.left;
                } else {
                    first = p.right;
                }
            }
            if(p.left != null) {
                if(last != null) {
                    last.next = p.left;
                }
                last = p.left;
            }
            if(p.right != null) {
                if(last != null) {
                    last.next = p.right;
                }
                last = p.right;
            }
            if(p.next == null) {
                p = first;
                first = null;
                last = null;
            } else {
                p = p.next;
            }
        }
        return;
    }
}
    
