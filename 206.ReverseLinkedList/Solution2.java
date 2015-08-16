/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode nextNode = head.next;
        ListNode h = reverseList(head.next);
        
        if(nextNode != null) {
            nextNode.next = head;
            head.next = null;
        }
        
        return h != null ? h : head;
    }
}