public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode oddHead = new ListNode(-1);
    ListNode evenHead = new ListNode(-2);
    ListNode oddEnd = oddHead;
    ListNode evenEnd = evenHead;

    int i = 1;
    while(head != null) {
      if(i % 2 == 1) {
        oddEnd.next = head;
        oddEnd = oddEnd.next;
      } else {
        evenEnd.next = head;
        evenEnd = evenEnd.next;
      }
      head = head.next;
      evenEnd.next = null;
      oddEnd.next = null;
      i++;
    }
    oddEnd.next = evenHead.next;
    evenEnd.next = null;

    return oddHead.next;
  }
}
