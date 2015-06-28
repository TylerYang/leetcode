public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nextNode = head;
        head = new ListNode(0);
        ListNode p = head;
        while(nextNode != null && nextNode.next != null) {
            ListNode prev = nextNode, curr = nextNode.next;
            nextNode = curr.next;
            
            p.next = curr;
            curr.next = prev;
            prev.next = nextNode;
            
            p = prev;
        }
        return head.next;
    }

}
