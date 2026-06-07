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

        while(mover != null) {
            Node temp = new Node(mover.val);
            map.put(mover, temp);
            mover = mover.next;
        }

        for(Map.Entry<Node, Node> entry : map.entrySet()) {
            Node original = entry.getKey();
            Node copy = entry.getValue();
            copy.next = map.get(original.next); 
            copy.random = map.get(original.random);  
        }

        return map.get(head);
    }
}
