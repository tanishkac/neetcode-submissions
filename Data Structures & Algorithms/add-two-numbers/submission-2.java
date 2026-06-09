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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(temp1 != null && temp2 != null) {

            int sum = carry + temp1.val + temp2.val;
            carry = sum/10;

            ListNode node = new ListNode(sum%10);
            
            temp.next = node;
            temp = node;

            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        while(temp1 != null) {
    
            int sum = carry + temp1.val;
            carry = sum/10;
            
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = node;
            temp1 = temp1.next;
            
        }

        while(temp2 != null) {
    
            int sum = carry + temp2.val;
            carry = sum/10;
            
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = node;
            temp2 = temp2.next;
            
        }

        if(carry == 1) {
            ListNode node = new ListNode(1);
            temp.next = node;
            temp = node;
        }

        temp.next = null;

        ListNode head = dummy.next;
        dummy.next = null;

        return head;
    }
}
