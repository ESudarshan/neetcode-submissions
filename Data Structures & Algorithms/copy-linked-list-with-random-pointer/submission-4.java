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
/*
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while(curr != null) {
            Node newCurr = new Node(curr.val);
            map.put(curr, newCurr);
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
*/

/*
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while(curr != null) {
            Node newCurr = getNode(map, curr);
            newCurr.next = getNode(map, curr.next);
            newCurr.random = getNode(map, curr.random);
            curr = curr.next;
        }
        return map.get(head);
*/

        if(head == null) {
            return null;
        }
       
        Node curr = head;
        while(curr != null) {
            Node newCurr = new Node(curr.val);
            newCurr.next = curr.random;
            curr.random = newCurr;
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null) {
            Node newCurr = curr.random;
            if(newCurr.next != null) {
                newCurr.random = newCurr.next.random; 
            } else {
                newCurr.random = null;
            }
            curr = curr.next;
        }

        Node newHead = head.random;
        curr = head;
        while(curr != null) {
            Node newCurr = curr.random;
            curr.random =  newCurr.next;
            if(curr.next != null) {
                newCurr.next = curr.next.random;  
            } else {
                newCurr.next = null;
            }
            curr = curr.next;
        }
        return newHead;
    }

    public Node getNode(Map<Node, Node> map, Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }

}
