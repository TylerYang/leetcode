public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sh = new ListNode(0), lh = new ListNode(0);
        ListNode s = sh, l = lh;
        while(head != null) {
            if(head.val < x) {
                s.next = head;
                head = head.next;
                s = s.next;
                s.next = null;
            } else {
                l.next = head;
                head = head.next;
                l = l.next;
                l.next = null;
            }
        }
        s.next = lh.next;
        return sh.next;
    }
}
