/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count=0;
        ListNode dummy = new ListNode(0, head);
        ListNode temp = head;

        while(temp != null) {
            temp = temp.next;
            count++;
        }

        temp = dummy;
        int j=1;

        while(j <= count-n) {
            temp = temp.next;
            j++;
        }

        ListNode toDel = temp.next;
        temp.next = temp.next.next;
        toDel.next = null;

        if(toDel == head) {
            head = dummy.next;
        }

        dummy.next = null;

        return head;

    }
}
