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
        Node newHead = null;
        Node curr = head;
        while(curr != null) {
            Node newCurr = new Node(curr.val);
            if(newHead == null) {
                newHead = newCurr;
            }
            newCurr.next = curr.random;
            curr.random = newCurr;
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node newCurr = curr.random;
            if(newCurr.next != null) {
                newCurr.random = newCurr.next.random;
            }
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node newCurr = curr.random;
            curr.random = newCurr.next;
            if(curr.next != null) {
                newCurr.next = curr.next.random;
            } else {
                newCurr.next = null;
            }
            curr = curr.next;
        }

        return newHead;
    }
}
