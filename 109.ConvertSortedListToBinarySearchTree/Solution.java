public class Solution {
    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        curr = head; 
        while(head != null) {
            len++;
            head = head.next;
        }
        return sortedListToBST(len);
    }
    private TreeNode sortedListToBST(int size) {
        if(size <= 0) return null;
        
        TreeNode leftChild = sortedListToBST(size / 2);
        TreeNode root = new TreeNode(curr.val);
        
        curr = curr.next;
        TreeNode rightChild = sortedListToBST(size - 1 - size / 2);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }
}
