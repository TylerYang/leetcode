public class Solution {
    public void deleteNode(ListNode node) {
        while(node != null) {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            if(nextNode.next == null) {
                node.next = null;
                break;
            } else {
                node = nextNode;
            }
        }
    }
}
