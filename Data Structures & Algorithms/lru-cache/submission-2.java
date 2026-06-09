class LRUCache {
    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node() {}
        Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    int count;
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new Node();
        this.tail = head;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node temp = map.get(key);
            if(temp == tail) {
                return tail.val;
            }
            else if(temp == head) {
                head = head.next;
                head.prev = null;
                temp.next = null;
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
                return tail.val;
            }
            else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = temp;
                return tail.val;
            }
        }
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
    if(count == 0 && capacity > 0) {
        Node temp = new Node(key, value, null, null);
        head = temp;
        tail = temp;
        map.put(key, temp);
        count++;
    } else {
        if(count < capacity) {
            count++;
            Node temp = new Node(key, value, null, null);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            map.put(key, temp);
        } else {
            Node temp = new Node(key, value, null, null);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            map.put(key, temp);
            
            temp = head;
            head = head.next;
            head.prev = null;
            map.remove(temp.key);
            temp.next = null;
        }
    }
} else {
    Node temp = map.get(key);
    
    if(temp == tail) {
        temp.val = value;
    }
    else if(temp == head) {
        temp.val = value;
        head = head.next;
        head.prev = null;
        temp.next = null;
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    } 
    else {
        temp.val = value;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        tail.next = temp;
        temp.prev = tail;
        temp.next = null;
        tail = temp;
    }
}
    }
}




