/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) { 
            return headA;  
        }
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null || nodeB != null) {
            if(nodeA != null){ 
                nodeA = nodeA.next;
                lenA++;
            }
            if(nodeB != null) {
                nodeB = nodeB.next;
                lenB++;
            }
        }
        
        nodeA = headA;
        nodeB = headB;
        while(lenA < lenB) {
            nodeB = nodeB.next;
            lenB--;
        }
        while(lenB < lenA) {
            nodeA = nodeA.next;
            lenA--;
        }
        
        while(nodeA != null && nodeB != null && nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA == nodeB ? nodeA : null;
    }
}