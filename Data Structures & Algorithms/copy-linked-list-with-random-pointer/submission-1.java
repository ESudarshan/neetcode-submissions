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
        Node curr = head;
        Node newPrev = null;
        Node newHead = null;
        Map<Node, Node> map = new HashMap<>();
        while(curr != null) {
            Node newCurr = new Node(curr.val);
            if(newPrev != null) {
                newPrev.next = newCurr;
            } else {
                newHead = newCurr;
            }
            map.put(curr, newCurr);
            newPrev = newCurr;
            curr = curr.next;
        }

        curr = head;
        Node newCurr = newHead;
        while(curr != null) {
            Node newRandom = map.get(curr.random);
            newCurr.random = newRandom;
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
