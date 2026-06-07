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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode temp1 = list1;
        ListNode temp2 = list2;
       
        ListNode head = new ListNode();
        ListNode mover = head;

        while((temp1 != null && temp2 != null)) {
            if(temp2.val > temp1.val) {
                mover.next = temp1;
                mover = temp1;
                temp1 = temp1.next;
            } else {
                mover.next = temp2;
                mover = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) {
            mover.next = temp1;
        }

        if(temp2 != null) {
            mover.next = temp2;
        }

        head = head.next;

        return head;
    }
}