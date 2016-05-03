public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode nextCurr = null;
        while (curr != null) {
            TreeLinkNode tmp = curr;
            prev = null;
            nextCurr = null;

            while (tmp != null) {
                if (tmp.left != null) {
                    if (prev != null) {
                        prev.next = tmp.left;
                    }

                    if (tmp.right == null) {
                        prev = tmp.left;
                    } else {
                        tmp.left.next = tmp.right;
                        prev = tmp.right;
                    }
                    if (nextCurr == null) {
                        nextCurr = tmp.left;
                    }
                } else if(tmp.right != null) {
                    if (prev != null) {
                        prev.next = tmp.right;
                    }
                    prev = tmp.right;

                    if (nextCurr == null) {
                        nextCurr = tmp.right;
                    }
                }

                tmp = tmp.next;
            }
            curr = nextCurr;
        }
        return;
    }
}
    
