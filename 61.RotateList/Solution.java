public class Solution {
    public ListNode ratoteRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode lastNode = head;
        int len = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            len++;
        }
        
        k %= len;
        if(k == 0) return;

        ListNode tmpNode = head;
        for(int i = 0; i < len - k - 1; i++) {
            tmpNode = tmpNode.next;
        }
        head = tmpNode.next;
        tmpNode.next = null;

        return head;
    }
}
