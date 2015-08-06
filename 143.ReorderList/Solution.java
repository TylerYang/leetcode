/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow.next == null) return;
        ListNode tmpNode = slow.next;
        slow.next = null;
        
        ListNode rHead = reverse(tmpNode);
        
        ListNode h = new ListNode(0), node = h;
        while(head != null && rHead != null) {
            node.next = head;
            head = head.next;
            node = node.next; 
            
            node.next = rHead;
            rHead = rHead.next;
            node = node.next;
            
            node.next = null;
        }
        if(head != null) node.next = head;
        
        return;
    }
    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode h = new ListNode(0);
        
        h.next = head;
        head = head.next;
        h.next.next = null;
        
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            
            tmp.next = h.next;
            h.next = tmp;
        }
        
        return h.next;
    }
    
}