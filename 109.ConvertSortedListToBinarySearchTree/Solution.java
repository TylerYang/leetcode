public class Solution {
    //return height balanced binary search tree
    public TreeNode sortedListToBST(ListNode head) {
        return genBST(head, null);
    }
    //1->3
    private TreeNode genBST(ListNode head, ListNode end) {
        if (head == null) return null;
        if (head.next == end) {
            return new TreeNode(head.val);
        }
        //1 null
        ListNode mid = getMidNode(head, end);
        //1

        TreeNode root = new TreeNode(mid.val);

        if (head != mid) {
            TreeNode left = genBST(head, mid);
            root.left = left;
        }

        TreeNode right = genBST(mid.next, end);
        root.right = right;
        return root;
    }
    private ListNode getMidNode(ListNode head, ListNode end) {
        if (head.next == null || head == end) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != end) {
            fast = fast.next;
            if (fast != end) {
                fast = fast.next;
            }
            if (fast == end) break;
            slow = slow.next;
        }

        return slow;
    }
}
