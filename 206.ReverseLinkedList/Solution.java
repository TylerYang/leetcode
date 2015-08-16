/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0), node = h;
        while(head != null) {
            ListNode tmp = head.next;
            
            head.next = node.next;
            node.next = head;
            
            head = tmp;
            
        }
        return h.next;
        
    }
}