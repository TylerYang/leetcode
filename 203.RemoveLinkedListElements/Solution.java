/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0), node = h;
        while(head != null) {
            if(val != head.val) {
                node.next = head;
                head = head.next;
                
                node = node.next;
                node.next = null;
            } else {
                head = head.next;
            }
        }
        return h.next;
    }
}