public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;

            if(fast != null) {
                fast = fast.next;
            }
        }
        ListNode rh = revertList(slow);
        ListNode node = head;
        while(node != slow && rh != null && node != null) {
            if(rh.val != node.val) return false;
            node = node.next;
            rh = rh.next;
        }
        revertList(rh);

        return true;
    }
    // 1 -> 2 -> 3 -> 4 -> 5
    private ListNode revertList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);

        // n4.next = n5;

        System.out.println(sol.isPalindrome(null));
    }
}
class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {
        this.val = val;
    }
}
