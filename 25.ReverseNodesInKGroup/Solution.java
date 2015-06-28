public class Solution {
    public ListNode reverseGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) return head;
        ListNode s = head, e = null;
        head = new ListNode(0);
        ListNode p = head;
        p.next = s;
        while(s != null && (e = moveToKthNodeFrom(s, k - 1)) != null) {
            ListNode prevS = s;
            ListNode nextS = e.next;
            s = s.next;
            while(p.next != e) {
                ListNode tmp = s.next;
                s.next = p.next;
                p.next = s;
                s = tmp;
            }
            p = prevS;
            s = nextS;
            p.next = s;
        }
        return head.next;
    }
    private ListNode moveToKthNodeFrom(ListNode head, int k) {
        for(int i = 0; i < k && head != null; i++) {
            head = head.next;
        }
        return head;
    }
}
