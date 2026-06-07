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
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        ListNode temp1 = head;
        int j=0;

        while(temp != null) {
            map.put(j, temp);
            temp = temp.next;
            j++;
        }

        int n = map.size();
        int i=1;
        int k=1;
        int m=1;
        
        while(k<n) {
            if(k % 2 != 0) {
                temp1.next = map.get(n-i);
                temp1 = temp1.next;
                i++;
                k++;
            } else {
                
                temp1.next = map.get(m);
                temp1 = temp1.next;
                k++;
                m++;
            }
            
        }

        temp1.next = null;

    }
}
