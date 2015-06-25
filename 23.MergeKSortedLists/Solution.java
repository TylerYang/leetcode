public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return merKLists(lists, 0, lists.length);
    }
    public ListNode merKLists(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        int mid = (left + right)/2;
        ListNode leftNode = merKLists(lists, left, mid);
        ListNode rightNode = merKLists(lists, mid + 1, right);
        return mergeTwoSortedLists(leftNode, rightNode);
    }
    
    private ListNode mergeTwoSortedLists(ListNode leftNode, ListNode rightNode) {
        if(leftNode == null) return rightNode;
        if(rightNode == null) return leftNode;
        ListNode head = new ListNode(0);
        ListNode curr = head; 
        while(leftNode != null && rightNode != null) {
            if(leftNode.val < rightNode.val) {
                curr.next = leftNode;
                leftNode = leftNode.next;
            } else {
                curr.next = rightNode;
                rightNode = rightNode.next;
            }
            curr = curr.next;
        }
        if(leftNode == null){
            curr.next = rightNode;
        } else {
            curr.next = leftNode;
        }
        return head.next;
    }

}
