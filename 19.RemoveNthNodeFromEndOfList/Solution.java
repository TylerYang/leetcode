public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        if(head.next == null){
            if(n == 1) return head.next;
            return head;
        }
        ListNode fast = head, slow = head;
        while(n-- > 0) {
            fast = fast.next;
            if(fast == null && n > 0) return head;
        }
        
        if(fast == null){
            head = head.next;
        } else {
            while(fast != null){
                fast = fast.next;
                if(fast != null) slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head; 
    } 
    public static void main(String[] args){
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        sol.printList(n1);
        
        
        ListNode head = sol.removeNthFromEnd(n1, 2);
        sol.printList(head);
        
    }
    private void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
            if(head != null) System.out.print(" => ");
        }
        System.out.println("");
    }
}
