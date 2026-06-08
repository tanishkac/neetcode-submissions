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
    public void reorderList(ListNode head) {
        
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        ListNode headd = s.next;
        s.next = null;

        ListNode prev = null;
        ListNode curr = headd;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        headd = prev;

        ListNode temp1 = head;
        ListNode temp2 = headd;
        
        while(temp1 != null && temp2 != null) {
            ListNode temp = temp2;
            temp2 = temp2.next;
            temp.next = temp1.next;
            temp1.next = temp;
            if(temp1.next != null) {
                temp1 = temp1.next.next;
            } else {
                break;
            }
        }

        if(temp2 != null) {
            temp1.next = temp2;
        }

        
    }
}
