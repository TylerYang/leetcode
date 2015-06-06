public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int inc = 0;
        ListNode head = null;
        ListNode curr = null;
        while(l1 != null || l2 != null){
            int val = inc;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            if(val >= 10){
                val %= 10;
                inc = 1;
            } else {
                inc = 0;    
            }
            ListNode currNode = new ListNode(val);
            if(head == null){
                head = currNode;
            }
            if(curr != null){
                curr.next = currNode;
            }
            curr = currNode;
        }
        if(inc > 0) curr.next = new ListNode(inc);
        return head; 
    }
}
