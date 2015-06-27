import java.util.Comparator;
public class SolutionMyPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        MyPriorityQueue<ListNode> pq = new MyPriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for(int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(pq.size() > 0) {
            ListNode node = pq.poll();
            curr.next = node;
            if(node.next != null) pq.add(node.next);
            curr = curr.next;
        }
        return head.next;
    }
}
