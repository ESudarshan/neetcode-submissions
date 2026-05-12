class LRUCache {

    Map<Integer, Node> map;
    Node head;
    int capacity;

    public LRUCache(int capacity) {
        this.map  = new HashMap<>();
        this.head = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            newHead(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            newHead(node); 
        } else {
            if(map.size() == capacity) {
                Node curr = head;
                while(curr.next != null) {
                    curr = curr.next;
                }
                map.remove(curr.key);
                remove(curr);
            }
            Node node = new Node(key, value);
            newHead(node);
            map.put(key, node);
        }
    }

    public void remove(Node node) {
        if(node == head) {
            head = null;
        } else {
            if(node.prev != null) {
                node.prev.next = node.next;
            }
            if(node.next != null) {
                node.next.prev =  node.prev;
            }
        }
    }

    public void newHead(Node node) {
        if(head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
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
