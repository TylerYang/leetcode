/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
    
        
        while(head != null) {
            ListNode node = h;
            while(node.next != null && head.val > node.next.val) {
                node = node.next;
            }
            ListNode tmp = node.next;
            
            node.next = head;
            
            head = head.next;
            
            node.next.next = tmp;
        
        }
        
        return h.next;
    }
}