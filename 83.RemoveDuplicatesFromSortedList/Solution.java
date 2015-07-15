public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode(0);
        ListNode n = h;
        while(head != null) {
            if(head.next == null || head.next.val != head.val) {
                n.next = head;
                n = n.next;
                head = head.next;
                n.next = null;
            } else {
                head = head.next;
            }
        }    
        return h.next;
    }
}
