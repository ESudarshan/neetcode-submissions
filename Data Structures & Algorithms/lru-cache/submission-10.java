class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map  = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            append(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            append(node); 
        } else {
            if(map.size() == capacity) {
                Node curr = head;
                map.remove(curr.key);
                remove(curr);
            }
            Node node = new Node(key, value);
            append(node);
            map.put(key, node);
        }
    }

    public void remove(Node node) {
        if(node == head && node == tail) {
            head = null;
            tail = null;
        } else if(node == head){ 
            head = head.next;
            head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev; 
        }
    }

    public void append(Node node) {
        if(head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}
