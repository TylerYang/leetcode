import java.util.Comparator;
import java.util.PriorityQueue;
public class SolutionPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val < l2.val ? -1 : 1;
            }
        });
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) pq.add(lists[i]);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(pq.size() > 0) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            node = node.next;
            if(node != null) pq.add(node);
        }
        return head.next; 
    }    
}
