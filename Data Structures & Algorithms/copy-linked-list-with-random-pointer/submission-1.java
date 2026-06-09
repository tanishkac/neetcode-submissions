/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node mover = head;
        Node dummy = new Node(0);
        Node prev = dummy;

        while(mover != null) {
            Node temp = new Node(mover.val);
            prev.next = temp;
            prev = temp;
            map.put(mover, temp);
            mover=mover.next;
        }

        prev.next = null;

        Node headd = dummy.next;
        dummy.next = null;
        mover = headd;

        for(Map.Entry<Node, Node> entry : map.entrySet()) {
                Node og = entry.getKey();
                Node copy = entry.getValue();

                copy.random = map.get(og.random);
        }
    
        return headd;

    }
}
