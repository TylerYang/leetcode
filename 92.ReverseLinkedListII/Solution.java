public  class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        int i = 1;
        ListNode h = new ListNode(0), curr = h, tail = null;
        while(i <= n) {
            if(i <= m) {
                curr.next = head;
                head = head.next;
                
                curr.next.next = null;

                if(i == m) {
                    tail = curr.next;
                } else {
                    curr = curr.next;
                }
                
            } else {
                ListNode node = head;
                head = head.next;
                node.next = curr.next;
                curr.next = node;
            }
        }
        if(head != null) tail.next = head;
            
        return h.next;
    }
}
